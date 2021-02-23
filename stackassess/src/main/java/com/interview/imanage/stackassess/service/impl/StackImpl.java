package com.interview.imanage.stackassess.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.interview.imanage.stackassess.exception.StackEmptyException;
import com.interview.imanage.stackassess.exception.StackInvalidDataException;
import com.interview.imanage.stackassess.exception.StackOverflowException;
import com.interview.imanage.stackassess.service.Stack;

@Service
public class StackImpl implements Stack {

	private int arr[];
	private int top;
	private int capacity;

	StackImpl(int size) {
		arr = new int[size];
		capacity = size;
		top = -1;
	}

	StackImpl() {
		arr = new int[2];
		capacity = 2;
		top = -1;
	}

	@Override
	public void push(Integer inputData) throws StackOverflowException, StackInvalidDataException {
		if (isFull()) {
			throw new StackOverflowException(inputData);
		}
		if (inputData == null)
			throw new StackInvalidDataException(inputData);
		arr[++top] = inputData;

	}

	@Override
	public Integer pop() throws StackEmptyException {
		if (isEmpty()) {
			throw new StackEmptyException();
		}

		// decrease stack size by 1 and (optionally) return the popped element
		return arr[top--];
	}

	@Override
	public Integer peek() throws StackEmptyException {
		if (!isEmpty())
			return arr[top];
		else {
			throw new StackEmptyException();
		}
	}

	@Override
	public int size() {
		return top + 1;
	}

	@Override
	public Boolean isEmpty() {
		return top == -1;
	}

	@Override
	public Boolean isFull() {
		return top == capacity - 1;
	}

	@Override
	public List<Integer> listAll() {
		List<Integer> tempList = new ArrayList<Integer>(capacity);

		for (int i = 0; i <= top; i++)
			tempList.add(arr[i]);
		return tempList;
	}

	@Override
	public void setSize(Integer size) {
		arr = null;
		arr = new int[size.intValue()];
		capacity = size.intValue();
		top = -1;
	}

}
