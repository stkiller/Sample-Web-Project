package com.stkiller.webexample.dal.exceptions;

public class DBException extends Exception {

	/**
     * 
     */
	private static final long serialVersionUID = 6592411294557512917L;

	public DBException() {
		super();
	}

	public DBException(String message) {
		super(message);
	}

	public DBException(Throwable cause) {
		super(cause);
	}

	public DBException(String message, Throwable cause) {
		super(message, cause);
	}
}
