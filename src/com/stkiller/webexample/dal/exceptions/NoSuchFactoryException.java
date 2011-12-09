/**
 * 
 */
package com.stkiller.webexample.dal.exceptions;

/**
 * @author stkiller
 * 
 */
public class NoSuchFactoryException extends Exception {

	private static final long serialVersionUID = -1639883528405305176L;

	public NoSuchFactoryException() {
		super();
	}

	/**
	 * @param message
	 */
	public NoSuchFactoryException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public NoSuchFactoryException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NoSuchFactoryException(String message, Throwable cause) {
		super(message, cause);
	}

}
