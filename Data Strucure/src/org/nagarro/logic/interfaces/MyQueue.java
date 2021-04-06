package org.nagarro.logic.interfaces;

public interface MyQueue<T> extends Iterable<T> {

	public boolean add(T data);

	public T remove();

	public int size();

	public void traverse();

	public boolean enqueue(T data);

	public T dequeue();

	public T peek();

	public boolean contains(T data);

	public void reverse();
}
