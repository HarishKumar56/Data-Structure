package org.nagarro.logic.interfaces;

public interface MyStack<T> extends Iterable<T> {

	public boolean add(T data);

	public T remove();

	public int size();

	public void traverse();

	public boolean push(T data);

	public T pop();

	public T peek();

	public boolean contains(T data);

	public void reverse();

}
