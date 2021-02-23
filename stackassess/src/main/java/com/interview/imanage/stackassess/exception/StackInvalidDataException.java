package com.interview.imanage.stackassess.exception;

public class StackInvalidDataException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StackInvalidDataException(Integer inputData) {
		super("Invalid Data from push request - " + inputData);
	}

}
