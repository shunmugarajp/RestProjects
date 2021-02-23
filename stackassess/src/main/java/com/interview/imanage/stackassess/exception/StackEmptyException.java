package com.interview.imanage.stackassess.exception;

public class StackEmptyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StackEmptyException() {
		super("No Data found to pop");
	}
}
