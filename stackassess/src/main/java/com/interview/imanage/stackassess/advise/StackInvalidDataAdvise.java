package com.interview.imanage.stackassess.advise;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.interview.imanage.stackassess.exception.StackInvalidDataException;

@ControllerAdvice
public class StackInvalidDataAdvise {

	@ResponseBody
	@ExceptionHandler(StackInvalidDataException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	String stackInvalidDataHandler(StackInvalidDataException ex) {
		return ex.getMessage();
	}

}
