package com.github.highcharts4gwt.generator.option.klass;

import com.github.highcharts4gwt.generator.ClassRegistry;
import com.github.highcharts4gwt.generator.OutputType;
import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JDefinedClass;

public abstract class ConcreteClassWriter extends BaseClassWriter
{
    public ConcreteClassWriter(String rootDirectory) throws JClassAlreadyExistsException
    {
        super(rootDirectory);
    }

    @Override
    protected JDefinedClass createJClass() throws JClassAlreadyExistsException
    {
        String fullyqualifiedName = getPackageName() + "." + getPrefix() + getShortClassName();
        return getCodeModel()._class(fullyqualifiedName, getClassType())._implements(getInterface());
    }

    protected JClass getInterface()
    {
        ClassRegistry.RegistryKey interfaceKey = new ClassRegistry.RegistryKey(getOption(), OutputType.Interface);
        return ClassRegistry.INSTANCE.getRegistry().get(interfaceKey);
    }

    @Override
    protected ClassType getClassType()
    {
        return ClassType.CLASS;
    }
}
