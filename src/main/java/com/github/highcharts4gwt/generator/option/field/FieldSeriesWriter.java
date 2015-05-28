package com.github.highcharts4gwt.generator.option.field;

import com.github.highcharts4gwt.generator.common.OutputTypeVisitor;
import com.github.highcharts4gwt.generator.option.Option;
import com.github.highcharts4gwt.model.array.api.Array;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;

public class FieldSeriesWriter extends FieldArrayObjectWriter implements OutputTypeVisitor<Void, Void>
{
    public FieldSeriesWriter(JDefinedClass jClass, Option option, boolean pipe, String fieldName)
    {
        super(jClass, option, pipe, fieldName);
    }

    @Override
    protected String getNameExtension()
    {
        return "AsSeries";
    }
    
    @Override
    protected JClass getNarrowedArrayClass()
    {
        
        //TODO #series hack
        JCodeModel codeModel = new JCodeModel();
        JDefinedClass definedClass;
        
        try
        {
            definedClass = codeModel._class("java.lang.Object");
            
            JClass genericArray = new JCodeModel().ref(Array.class);
            JClass arrayOfSpecializedType = genericArray.narrow(definedClass);
            return arrayOfSpecializedType;
        }
        catch (JClassAlreadyExistsException e)
        {
            throw new RuntimeException();
        }
        
    }
}
