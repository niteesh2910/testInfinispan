package com.test.niteesh.entity;

import java.io.Serializable;

public class ApplicationProperty implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String value;
	private String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}