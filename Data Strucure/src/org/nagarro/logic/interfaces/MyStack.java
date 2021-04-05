package org.nagarro.logic.interfaces;

public interface MyStack<T> extends MyCollection<T> {
	
	public boolean push(T data);
	
	public T pop() ;
	
	public T peek();
	
	public boolean contains(T data) ;
	
	public void reverse();

}
