package org.nagarro.logic.interfaces;

public interface MyGenericTree<T> extends Iterable<T> {
	
	public boolean add(T data);
	
	public T remove();
	
	public boolean contains(T data);
	
	public void traverseBFS();
	
	public void traverseDFS();
	

}
