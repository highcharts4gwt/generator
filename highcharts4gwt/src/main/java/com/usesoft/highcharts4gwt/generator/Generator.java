package com.usesoft.highcharts4gwt.generator;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;


import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.usesoft.highcharts4gwt.generator.graph.GraphMultiRoot;
import com.usesoft.highcharts4gwt.generator.graph.OptionNode;
import com.usesoft.highcharts4gwt.generator.jsonparser.Nodeparser;

public class Generator {

	private static final String CONFIGURATION_FILENAME = "configuration.properties";
	private static final String GENERATOR_INPUT_FILENAME = "generator.input.optionsUrl";
	private static final String GENERATOR_OUTPUT_PACKAGENAME = "generator.output.packageName";

	public Generator() {
	}

	public void generate() throws IOException, JClassAlreadyExistsException {

		Properties properties = loadProperties();
		String packageName = getPackageName(properties);
		cleanPackage(packageName);

		createGraph(properties);

		createClasses(packageName);
	}

	private void createGraph(Properties properties) throws IOException,
			FileNotFoundException {

		String optionsAsString = getOptionsAsString(properties);
		
		JSONObject options = new JSONObject(optionsAsString);
		JSONObject root = (JSONObject) options.get("Options");
		JSONArray jsonArray = root.getJSONArray("options");
		
		GraphMultiRoot graph = new GraphMultiRoot();
		List<OptionNode> roots = new ArrayList<OptionNode>();
		for (int i = 0; i < jsonArray.length(); i++) {
			
			roots.add(Nodeparser.parse((JSONObject) jsonArray.get(i)));
		}
		graph.setRoots(roots);
		System.out.println(options);
	}

	private String getOptionsAsString(Properties properties)
			throws IOException, FileNotFoundException, MalformedURLException,
			UnsupportedEncodingException {
		String optionsUrl = getOptionsDumpUrl(properties);

		InputStream IS = new URL(optionsUrl).openStream();

		ByteArrayOutputStream BAOS = new ByteArrayOutputStream();
		IOUtils.copy(IS, BAOS);
		String optionsAsString = new String(BAOS.toByteArray(), "UTF-8");
		return optionsAsString;
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

	private String getPackageName(Properties properties) throws IOException,
			FileNotFoundException {
		return properties.getProperty(GENERATOR_OUTPUT_PACKAGENAME);
	}

	private String getOptionsDumpUrl(Properties properties)
			throws IOException, FileNotFoundException {
		return properties.getProperty(GENERATOR_INPUT_FILENAME);
	}

	private Properties loadProperties() throws FileNotFoundException,
			IOException {
		Properties properties = new Properties();
		InputStream inputStream = this.getClass().getResourceAsStream(
				CONFIGURATION_FILENAME);
		if (inputStream == null) {
			throw new FileNotFoundException("property file '"
					+ CONFIGURATION_FILENAME + "' not found in the classpath");
		}

		properties.load(inputStream);
		return properties;
	}
}