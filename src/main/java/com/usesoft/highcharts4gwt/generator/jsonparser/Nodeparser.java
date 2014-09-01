package com.usesoft.highcharts4gwt.generator.jsonparser;

import org.json.JSONObject;

import com.usesoft.highcharts4gwt.generator.graph.OptionNode;

public class Nodeparser {
	
	private Nodeparser() {
	}

	public static OptionNode parse(JSONObject jsonOption){
		OptionNode node = new OptionNode();
		
//		node.setDefaults(jsonOption.get("defaults").toString());
//		node.setDemo(jsonOption.get("defaults"));
//		node.setDeprecated(jsonOption.get("defaults"));
//		node.setDescription(jsonOption.get("defaults"));
//		node.setExcluding(jsonOption.get("defaults"));
//		node.setExtending(jsonOption.get("defaults"));
//		node.setFullname(jsonOption.get("defaults"));
		node.setName(jsonOption.get("name").toString());
//		node.setIsParent(jsonOption.get("defaults"));
//		node.setReturnType(jsonOption.get("defaults"));
//		node.setSeeAlso(jsonOption.get("defaults"));
//		node.setSince(jsonOption.get("defaults"));
//		node.setTitle(jsonOption.get("defaults"));
//		node.setValues(jsonOption.get("defaults"));
		return node;
	}
}
