package com.gogate.demo.filetool.exceptions;

public class ParseException extends Exception{

	private static final long serialVersionUID = 1L;

	private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
