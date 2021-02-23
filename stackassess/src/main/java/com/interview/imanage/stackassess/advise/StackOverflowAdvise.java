package com.interview.imanage.stackassess.advise;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.interview.imanage.stackassess.exception.StackOverflowException;

@ControllerAdvice
public class StackOverflowAdvise {

	@ResponseBody
	@ExceptionHandler(StackOverflowException.class)
	@ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
	String stackEmptyHandler(StackOverflowException ex) {
		return ex.getMessage();
	}

}
