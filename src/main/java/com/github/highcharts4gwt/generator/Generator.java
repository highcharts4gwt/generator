package com.github.highcharts4gwt.generator;

import java.io.IOException;

import javax.annotation.CheckForNull;

import com.sun.codemodel.JClassAlreadyExistsException;

public interface Generator
{
    void generateClasses() throws IOException, JClassAlreadyExistsException;

    // void writeGeneratedClassesOnDisk();

    @CheckForNull
    String readProductOptionsFile() throws IOException;

    @CheckForNull
    String readProductObjectsFile() throws IOException;
}
