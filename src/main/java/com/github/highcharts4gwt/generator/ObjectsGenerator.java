package com.github.highcharts4gwt.generator;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.highcharts4gwt.generator.common.ClassRegistry;
import com.github.highcharts4gwt.generator.common.HasFullnameUtils;
import com.github.highcharts4gwt.generator.common.OutputType;
import com.github.highcharts4gwt.generator.common.field.FieldType;
import com.github.highcharts4gwt.generator.common.field.FieldTypeHelper;
import com.github.highcharts4gwt.generator.model.highsoft.Product;
import com.github.highcharts4gwt.generator.object.Object;
import com.github.highcharts4gwt.generator.object.ObjectFieldType;
import com.github.highcharts4gwt.generator.object.ObjectUtils;
import com.github.highcharts4gwt.generator.object.field.FieldWriterVisitor;
import com.github.highcharts4gwt.generator.object.jsonparser.ObjectParser;
import com.github.highcharts4gwt.generator.object.klass.ObjectClassWriter;
import com.github.highcharts4gwt.generator.object.klass.ObjectClassWritterVisitor;
import com.google.common.collect.Lists;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JDefinedClass;

public class ObjectsGenerator
{
    private static final Logger logger = LoggerFactory.getLogger(ObjectsGenerator.class);

    private final String objectsDescriptionAsString;
    private final Product product;
    private final String rootDirectory;
    private final String objectPackageName;

    private final List<ObjectClassWriter> writers;

    private List<Object> objects;

    public ObjectsGenerator(String objectsDescriptionAsString, Product product, String rootDirectory, String objectPackageName)
    {
        writers = Lists.newArrayList();
        this.objectsDescriptionAsString = objectsDescriptionAsString;
        this.product = product;
        this.rootDirectory = rootDirectory;
        this.objectPackageName = objectPackageName;
        logger.info("ObjectsGenerator instantiated;");
    }

    public void createEmptyObjectClasses() throws IOException, JClassAlreadyExistsException
    {
        objects = readObjects();
        List<Object> list = ObjectUtils.sortListBasedOnDependencies(objects);
        createObjectClasses(list);

        logger.info("Objects classes (empty) created;");
    }

    public void enrichObjectClassesWithFields()
    {
        for (Object object : objects)
        {
            if (HasFullnameUtils.isRoot(object))
                continue;

            if (!object.getType().equals(ObjectFieldType.Property.toString().toLowerCase()))
                continue;

            List<FieldType> types = FieldTypeHelper.findTypes(object);
            boolean pipe = false;
            if (types.size() > 1)
                pipe = true;

            for (OutputType outputType : OutputType.values())
            {
                String rootFullName = HasFullnameUtils.extractRootFullName(object);
                Object fakeRoot = new Object(rootFullName, rootFullName, rootFullName);
                ClassRegistry.RegistryKey key = new ClassRegistry.RegistryKey(fakeRoot, outputType);
                JDefinedClass jClass = (JDefinedClass) ClassRegistry.INSTANCE.getRegistry().get(key);

                for (FieldType fieldType : types)
                {
                    fieldType.accept(new FieldWriterVisitor(object, jClass, pipe, rootDirectory), outputType);
                }
            }
        }
    }

    public void writeObjectClassesToDisk() throws IOException
    {
        for (ObjectClassWriter writer : writers)
        {
            writer.writeClassToDisk();
        }

        logger.info("Objects classes written to disk;");
    }

    public void cleanObjectDirectory() throws IOException
    {
        String prePath = rootDirectory + "/";
        DirectoryUtils.cleanDirectory(prePath + DirectoryUtils.packageToPath(objectPackageName), logger);
    }

    private void createObjectClasses(List<Object> objects) throws IOException, JClassAlreadyExistsException
    {
        // Generate empty top level classes, needed because of cycle between
        // objects
        for (Object object : objects)
        {
            if (HasFullnameUtils.isRoot(object))
                createObjectEmptyClass(object);
        }
    }

    private void createObjectEmptyClass(Object object) throws IOException, JClassAlreadyExistsException
    {
        for (OutputType outputType : OutputType.values())
        {
            ObjectClassWriter writer = outputType.accept(new ObjectClassWritterVisitor(), rootDirectory);
            writers.add(writer);
            writeObjectClass(object, writer, outputType);
        }
    }

    private List<Object> readObjects() throws IOException
    {
        if (objectsDescriptionAsString == null)
            throw new RuntimeException("Cannot read objects from " + product.getProductPackageName());

        List<Object> objects = ObjectParser.parse(objectsDescriptionAsString);
        return objects;
    }

    private void writeObjectClass(Object object, ObjectClassWriter writer, OutputType outputType) throws IOException, JClassAlreadyExistsException
    {
        if (writer != null)
        {
            writer.setPackageName(HasFullnameUtils.computePackageName(object, outputType, objectPackageName)).setOject(object);
            writer.createClass();
        }
    }
}
