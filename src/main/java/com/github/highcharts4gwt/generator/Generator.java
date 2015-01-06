package com.github.highcharts4gwt.generator;

import java.io.IOException;

import javax.annotation.CheckForNull;

import com.sun.codemodel.JClassAlreadyExistsException;

public interface Generator
{
    void generate() throws IOException, JClassAlreadyExistsException;

    @CheckForNull
    String readProductOptionsFile() throws IOException;

    @CheckForNull
    String readProductObjectFile() throws IOException;
}
