package com.github.highcharts4gwt.generator;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;

public class DirectoryUtils
{
    private DirectoryUtils()
    {
    }

    public static void cleanDirectory(String dirPath, Logger logger) throws IOException
    {
        File directory = new File(dirPath);

        if (directory.isDirectory() && directory.exists())
        {
            FileUtils.cleanDirectory(directory);
            logger.info(dirPath + " cleaned;");
        }
    }

    public static String packageToPath(String packageName)
    {
        String path = packageName.replace(".", "/");
        return path;
    }
}
