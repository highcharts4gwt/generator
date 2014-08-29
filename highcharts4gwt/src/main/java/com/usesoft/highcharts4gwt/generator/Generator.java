package com.usesoft.highcharts4gwt.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;

public class Generator {

	private static final String CONFIGURATION_FILENAME = "configuration.properties";
	private static final String GENERATOR_OUTPUT_PACKAGENAME = "generator.output.packageName";

	public Generator() {
	}

	public void generate() throws IOException, JClassAlreadyExistsException {
		
		String packageName = getPackageName();
		
		cleanPackage(packageName);
		
		createClasses(packageName);
	}

	private void createClasses(String packageName)
			throws JClassAlreadyExistsException, IOException {
		
		JCodeModel codeModel = new JCodeModel();
		
		JDefinedClass definedClass = codeModel._class(packageName
				+ ".ClassNameTest");
		codeModel.build(new File("."));
	}

	private void cleanPackage(String packageName) throws IOException {
		String path = packageName.replace(".", "/");
		FileUtils.cleanDirectory(new File(path));
	}

	private String getPackageName() throws IOException, FileNotFoundException {
		Properties properties = new Properties();
		InputStream inputStream = this.getClass().getResourceAsStream(CONFIGURATION_FILENAME);
		if (inputStream == null) {
			throw new FileNotFoundException("property file '"
					+ CONFIGURATION_FILENAME + "' not found in the classpath");
		}

		properties.load(inputStream);
		return properties.getProperty(GENERATOR_OUTPUT_PACKAGENAME);
	}
}