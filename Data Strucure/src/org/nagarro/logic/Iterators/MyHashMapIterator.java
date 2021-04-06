package org.nagarro.logic.Iterators;

import java.util.Iterator;

import org.nagarro.logic.MyStackImpl;
import org.nagarro.logic.interfaces.MyStack;
import org.nagarro.logic.nodes.HashNode;

public class MyHashMapIterator<K, V> implements Iterator<HashNode<K, V>> {

	private int capacity;
	private HashNode<K, V>[] myHashMap;
	private int size;
	private MyStack<HashNode<K, V>> myStack;

	public MyHashMapIterator(int capacity, HashNode<K, V>[] myHashMap, int size) {
		super();
		this.capacity = capacity;
		this.myHashMap = myHashMap;
		this.size = size;
		myStack = new MyStackImpl<>();
	}

	@Override
	public boolean hasNext() {
		if (size > 0) {
			return true;
		}
		return false;
	}

	@Override
	public HashNode<K, V> next() {
		if (myStack.size() == 0) {
			hashIteratorHelper();

		}
		size--;
		return myStack.pop();
	}

	public void hashIteratorHelper() {

		while (myHashMap[capacity - 1] == null) {
			capacity--;
		}
		HashNode<K, V> tempNode = myHashMap[capacity - 1];
		while (tempNode != null) {
			myStack.push(tempNode);
			tempNode = tempNode.getNextNode();
		}
		capacity--;

	}

}
