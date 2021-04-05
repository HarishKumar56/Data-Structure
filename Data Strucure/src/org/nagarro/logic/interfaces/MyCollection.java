package org.nagarro.logic.interfaces;

public interface MyCollection<T> extends Iterable<T> {
	
	public boolean add(T data);
	
	public T remove();
	
	public int size();
	
	public void traverse();	

}
