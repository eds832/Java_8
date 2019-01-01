package com.epam.cdp.domain;

import java.util.Map;

public class Developer {
	
	private String name;
	private Map<String, Integer> skillMatrix;
	
	public Developer(String name, Map<String, Integer> skillMatrix) {
		super();
		this.name = name;
		this.skillMatrix = skillMatrix;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Integer> getSkillMatrix() {
		return skillMatrix;
	}
	public void setSkillMatrix(Map<String, Integer> skillMatrix) {
		this.skillMatrix = skillMatrix;
	}

}
