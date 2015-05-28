package com.github.highcharts4gwt.generator.option.klass;

import com.github.highcharts4gwt.generator.common.OutputType;
import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JDefinedClass;

public class InterfaceClassWriter extends BaseClassWriter
{
    // private static final String CLASS_PREFIX = "api";

    public InterfaceClassWriter(String rootDirectory) throws JClassAlreadyExistsException
    {
        super(rootDirectory);
    }

    @Override
    public String getPrefix()
    {
        return "";
    }

    @Override
    protected JDefinedClass createJClass() throws JClassAlreadyExistsException
    {
        String fullyqualifiedName = getFullyQualifiedName();
        
        JDefinedClass _class = getCodeModel()._class(fullyqualifiedName, getClassType());
        
        //TODO #series hack : create inheritance between interfaces series<xxx> and series
//        if (getOption().getFullname().matches("series<\\w+>"))
//        {
//            ClassRegistry.RegistryKey interfaceKey = new ClassRegistry.RegistryKey(new Option("series", "", ""), OutputType.Interface);
//             JClass seriesInterface = ClassRegistry.INSTANCE.getRegistry().get(interfaceKey);
//            _class._implements(seriesInterface);
//        }
        return _class;
    }

    

    @Override
    protected ClassType getClassType()
    {
        return ClassType.INTERFACE;
    }

    @Override
    public OutputType getOutputType()
    {
        return OutputType.Interface;
    }

}
