package com.interview.imanage.stackassess.advise;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import com.interview.imanage.stackassess.exception.StackEmptyException;

@ControllerAdvice
public class StackEmptyAdvise {
	
	
	@ResponseBody
	@ExceptionHandler(StackEmptyException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String stackEmptyHandler(StackEmptyException ex) {
		return ex.getMessage();
	}

}
