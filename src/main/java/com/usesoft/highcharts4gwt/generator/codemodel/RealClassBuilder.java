package com.usesoft.highcharts4gwt.generator.codemodel;

import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JDefinedClass;

public abstract class RealClassBuilder extends BaseClassWriter
{
    public RealClassBuilder(String rootDirectory) throws JClassAlreadyExistsException
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
        return ClassRegistry.INSTANCE.getRegistry().get(new ClassRegistry.RegistryKey(getOptionSpec(), OutputType.Interface));
    }

    @Override
    protected ClassType getClassType()
    {
        return ClassType.CLASS;
    }
}
