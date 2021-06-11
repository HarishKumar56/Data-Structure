package org.nagarro.logic.interfaces;

import org.nagarro.logic.nodes.GenericNode;

public interface MyGenericTree<T> extends Iterable<GenericNode<T>> {
	
	public T remove(T data);
	
	public boolean contains(T data);
	
	public void traverseBFS();
	
	public void traverseDFS();

	boolean add(T data, T parentData);
	
	public void elementByLevel(int level);
	
	public void elementsByValue(T data);
	

}
