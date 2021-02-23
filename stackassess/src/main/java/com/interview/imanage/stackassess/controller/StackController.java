package com.interview.imanage.stackassess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.interview.imanage.stackassess.exception.StackEmptyException;
import com.interview.imanage.stackassess.exception.StackInvalidDataException;
import com.interview.imanage.stackassess.exception.StackOverflowException;
import com.interview.imanage.stackassess.service.Stack;

@RestController
public class StackController {

	@Autowired
	Stack stackService;

	@GetMapping("/data")
	public List<Integer> fetchAll() {
		return stackService.listAll();

	}

	@PostMapping("/data")
	void push(@RequestBody Integer inputStackData) throws StackOverflowException,StackInvalidDataException {
		stackService.push(inputStackData);
	}

	@DeleteMapping("/data")
	void pop() throws StackEmptyException {
		stackService.pop();
	}

	@GetMapping("/size")
	int getStackSize() {
		return stackService.size();
	}
	
	@PutMapping("/size")
	void alterStackSize(@RequestBody Integer stackSize) {
		stackService.setSize(stackSize);
	}
}
