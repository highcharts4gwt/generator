package com.github.highcharts4gwt.generator.object.klass;

import com.github.highcharts4gwt.generator.ClassRegistry;
import com.github.highcharts4gwt.generator.OutputType;
import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JDefinedClass;

public abstract class ConcreteObjectClassWriter extends BaseObjectClassWriter
{
    public ConcreteObjectClassWriter(String rootDirectory)
    {
        super(rootDirectory);
    }

    @Override
    protected JDefinedClass declareType(String packageName, String className) throws JClassAlreadyExistsException
    {
        return getCodeModel()._class(packageName + "." + getPrefix() + className, getClassType())._implements(getInterface());
    }

    protected JClass getInterface()
    {
        return ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(getObject(), OutputType.Interface));
    }

    @Override
    protected ClassType getClassType()
    {
        return ClassType.CLASS;
    }
}
