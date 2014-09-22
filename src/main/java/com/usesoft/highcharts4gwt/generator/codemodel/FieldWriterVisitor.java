package com.usesoft.highcharts4gwt.generator.codemodel;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldArrayNumberWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldArrayObjectWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldArrayStringWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldBooleanWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldClassWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldNumberWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldStringWriter;
import com.usesoft.highcharts4gwt.generator.codemodel.field.FieldTypeVisitor;
import com.usesoft.highcharts4gwt.generator.graph.OptionSpec;

public class FieldWriterVisitor implements FieldTypeVisitor<OutputType, Void>
{
    private final String fieldName;
    private final JCodeModel codeModel;
    private final JDefinedClass jClass;
    private final String className;
    private final OptionSpec optionSpec;

    public FieldWriterVisitor(OptionSpec optionSpec, JCodeModel codeModel, JDefinedClass jClass, String className)
    {
        this.optionSpec = optionSpec;
        this.fieldName = optionSpec.getTitle();
        this.codeModel = codeModel;
        this.jClass = jClass;
        this.className = className;
    }

    @Override
    public Void visitNumber(OutputType in)
    {
        // System.out.println("fieldName :" + fieldName);
        // System.out.println("Number default :" + optionSpec.getDefaults());

        // TODO Report to HS - Strange cases with numbers ?
        Double defaultValue = null;
        if (optionSpec.getDefaults() != null && !optionSpec.getDefaults().equals("null") && !optionSpec.getDefaults().equals("undefined")
                && !optionSpec.getDefaults().equals(""))
            defaultValue = Double.parseDouble(optionSpec.getDefaults());
        return in.accept(new FieldNumberWriter(codeModel, jClass, className, defaultValue), fieldName);
    }

    @Override
    public Void visitBoolean(OutputType in)
    {
        boolean defaultValue = Boolean.parseBoolean(optionSpec.getDefaults());
        return in.accept(new FieldBooleanWriter(codeModel, jClass, className, defaultValue), fieldName);
    }

    @Override
    public Void visitString(OutputType in)
    {
        String defaultValue = optionSpec.getDefaults();
        return in.accept(new FieldStringWriter(codeModel, jClass, className, defaultValue), fieldName);
    }

    @Override
    public Void visitOther(OutputType in)
    {
        return null;
    }

    @Override
    public Void visitArrayString(OutputType in)
    {
        String defaultValue = optionSpec.getDefaults();
        return in.accept(new FieldArrayStringWriter(codeModel, jClass, className, defaultValue), fieldName);
    }

    @Override
    public Void visitArrayNumber(OutputType in)
    {
        String defaultValue = optionSpec.getDefaults();
        return in.accept(new FieldArrayNumberWriter(codeModel, jClass, className, defaultValue), fieldName);
    }

    @Override
    public Void visitArrayObject(OutputType in)
    {
        String defaultValue = optionSpec.getDefaults();
        return in.accept(new FieldArrayObjectWriter(codeModel, jClass, className, optionSpec, defaultValue), fieldName);
    }

    @Override
    public Void visitClass(OutputType in)
    {
        String defaultValue = optionSpec.getDefaults();

        return in.accept(new FieldClassWriter(codeModel, jClass, className, optionSpec, defaultValue), fieldName);
    }

}
