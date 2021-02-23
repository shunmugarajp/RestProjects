package com.interview.imanage.stackassess.exception;

public class StackOverflowException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StackOverflowException(Integer inputData){
		super("Stack Overflow; couldn't add the data - "+inputData);
	}

}
