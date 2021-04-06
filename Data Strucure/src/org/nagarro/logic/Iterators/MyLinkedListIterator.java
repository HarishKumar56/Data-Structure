package org.nagarro.logic.Iterators;

import java.util.Iterator;
import org.nagarro.logic.nodes.LinkedListNode;

public class MyLinkedListIterator<T> implements Iterator<T> {

	LinkedListNode<T> node;

	public MyLinkedListIterator(LinkedListNode<T> node) {
		super();
		this.node = node;
	}

	@Override
	public boolean hasNext() {
		if (node == null) {
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
