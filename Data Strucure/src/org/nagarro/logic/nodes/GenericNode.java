package org.nagarro.logic.nodes;

import org.nagarro.logic.MyLinkedListImpl;

public class GenericNode<T> {
	
	private T data;
	
	public GenericNode<T>[] treeChild;
	private int chilSize;

	public GenericNode(T data) {
		super();
		this.data = data;
		this.treeChild = new GenericNode[chilSize];
	}

	public GenericNode(T data , int treeChild) {
		super();
		this.data = data;
		this.chilSize = treeChild;
		this.treeChild = new GenericNode[treeChild];
	}
	
	

	public GenericNode() {
		super();
		this.data = null;
		this.treeChild = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	
	

}
