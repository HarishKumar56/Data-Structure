package org.nagarro.logic.interfaces;

public interface MyLinkedList<T> extends MyCollection<T> {
	
	public boolean insert(int position , T data);
	
	public T remove(int position);
	
	public void reverse();
	
	public T center();

}
