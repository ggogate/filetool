package com.gogate.demo.filetool.models;

public class Field {

    private int index;
    private String name;
    private int length;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

	@Override
	public String toString() {
		return "{ \"index\": " + index + ", \"name\": " + name + ", \"length\": " + length + " }";
	}
    
    
}
