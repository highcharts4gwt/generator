package com.usesoft.highcharts4gwt.generator;

import java.io.IOException;

import com.sun.codemodel.JClassAlreadyExistsException;

public interface Generator
{
    void generate() throws IOException, JClassAlreadyExistsException;

}
