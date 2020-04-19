/**
 * 
 */
package com.student.exceptions;

/**
 * @author VIRU
 *
 */
public class NullValueException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message="return null value";

	
	/**
	 * 
	 */
	public NullValueException()
	{
		
	}
	/**
	 * @param message
	 */
	public NullValueException(String message) {
		this.message = message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {

		return message;
	}
}