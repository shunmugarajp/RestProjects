package com.interview.imanage.stackassess.service;

import java.util.List;

import com.interview.imanage.stackassess.exception.StackEmptyException;
import com.interview.imanage.stackassess.exception.StackInvalidDataException;
import com.interview.imanage.stackassess.exception.StackOverflowException;

public interface Stack {

	public void push(Integer inputData) throws StackOverflowException, StackInvalidDataException;

	public Integer pop() throws StackEmptyException;

	public Integer peek() throws StackEmptyException;

	public int size();

	public Boolean isEmpty();

	public Boolean isFull();

	public List<Integer> listAll();

	public void setSize(Integer size);
}
