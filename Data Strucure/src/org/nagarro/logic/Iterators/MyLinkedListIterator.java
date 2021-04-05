package org.nagarro.logic.Iterators;

import java.util.Iterator;

import org.nagarro.logic.MyLinkedListImpl;

public class MyLinkedListIterator<T> implements Iterator<T> {
	
	MyLinkedListImpl<T>.LinkedListNode node;

	public MyLinkedListIterator(MyLinkedListImpl<T>.LinkedListNode node) {
		super();
		this.node = node;
	}

	@Override
	public boolean hasNext() {
		if(node == null) {
			return false;
		}
		return true;
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		T data = node.getData();
		node = node.getNextNode();
		return data;
	}

}
