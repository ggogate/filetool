package com.gogate.demo.filetool.models;

public class Value {

	private int index;
	private String value;
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "{ \"index\": " + index + ", \"value\": " + value + " }";
	}

	
}
