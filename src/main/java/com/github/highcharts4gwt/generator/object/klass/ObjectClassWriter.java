package com.github.highcharts4gwt.generator.object.klass;

import java.io.IOException;

import com.github.highcharts4gwt.generator.object.Object;
import com.sun.codemodel.JClassAlreadyExistsException;

public interface ObjectClassWriter
{
    ObjectClassWriter setPackageName(String packageName);

    void createClass() throws IOException, JClassAlreadyExistsException;

    void writeClassToDisk() throws IOException;

    ObjectClassWriter setOject(Object object);
}
