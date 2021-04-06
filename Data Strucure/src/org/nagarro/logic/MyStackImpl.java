package org.nagarro.logic;

import java.util.Iterator;

import org.nagarro.logic.interfaces.MyStack;

public class MyStackImpl<T> implements MyStack<T> {

	private MyLinkedListImpl<T> myStack;

	public MyStackImpl(T data) {
		myStack = new MyLinkedListImpl<>(data);
	}

	public MyStackImpl() {
		myStack = new MyLinkedListImpl<>();
	}

	public boolean push(T data) {
		return myStack.add(data);
	}

	public T pop() {
		if (myStack.size() <= 0) {
			throw new IllegalStateException("Stack is Emptpy");
		}
		return myStack.removeLast();
	}

	public T peek() {
		if (myStack.size() <= 0) {
			throw new IllegalStateException("Stack is Emptpy");
		}
		return myStack.getTail();
	}

	@Override
	public Iterator<T> iterator() {
		return myStack.iterator();
	}

	@Override
	public boolean contains(T data) {
		for (T val : myStack) {
			if (data.equals(val)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void reverse() {
		if (myStack.size() <= 0) {
			throw new IllegalStateException("Stack is Emptpy");
		}
		myStack.reverse();
	}

	@Override
	public int size() {
		return myStack.size();
	}

	@Override
	public void traverse() {
		if (myStack.size() <= 0) {
			throw new IllegalStateException("Stack is Emptpy");
		}
		myStack.traverse();

	}

	@Override
	public boolean add(T data) {
		return myStack.add(data);
	}

	@Override
	public T remove() {
		if (myStack.size() <= 0) {
			throw new IllegalStateException("Stack is Emptpy");
		}
		return myStack.removeLast();
	}

}
