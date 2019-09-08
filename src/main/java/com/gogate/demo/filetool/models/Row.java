package com.gogate.demo.filetool.models;

import java.util.List;

public class Row {

	private List<Value> values;

	public List<Value> getValues() {
		return values;
	}

	public void setValues(List<Value> values) {
		this.values = values;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Value value: values ) {
			sb.append(value.getValue());
		}
		return sb.toString();
	}
	
}
