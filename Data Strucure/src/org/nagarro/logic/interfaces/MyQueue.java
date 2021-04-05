package org.nagarro.logic.interfaces;

public interface MyQueue<T> extends MyCollection<T> {

	public boolean enqueue(T data);
	
	public T dequeue();
	
	public T peek();
	
	public boolean contains(T data) ;
	
	public void reverse();
}
