package org.nagarro.logic;

import java.util.Iterator;

import org.nagarro.logic.interfaces.MyQueue;

public class MyQueueImpl<T> implements MyQueue<T> {

	private MyLinkedListImpl<T> myQueue;

	public MyQueueImpl() {
		myQueue = new MyLinkedListImpl<>();

	}

	public MyQueueImpl(T data) {
		myQueue = new MyLinkedListImpl<>(data);

	}

	@Override
	public Iterator<T> iterator() {
		return myQueue.iterator();
	}

	@Override
	public boolean enqueue(T data) {
		return myQueue.add(data);
	}

	@Override
	public T dequeue() {
		if (myQueue.size() <= 0) {
			throw new IllegalStateException("Queue is Emptpy");
		}
		return myQueue.remove();
	}

	@Override
	public T peek() {
		if (myQueue.size() <= 0) {
			throw new IllegalStateException("Queue is Emptpy");
		}
		return myQueue.getHead();
	}

	@Override
	public boolean contains(T data) {
		for (T val : myQueue) {
			if (data.equals(val)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int size() {
		return myQueue.size();
	}

	@Override
	public void reverse() {
		if (myQueue.size() <= 0) {
			throw new IllegalStateException("Queue is Emptpy");
		}
		myQueue.reverse();
	}

	@Override
	public void traverse() {
		if (myQueue.size() <= 0) {
			throw new IllegalStateException("Queue is Emptpy");
		}
		myQueue.traverse();
	}

	@Override
	public boolean add(T data) {
		return myQueue.add(data);
	}

	@Override
	public T remove() {
		if (myQueue.size() <= 0) {
			throw new IllegalStateException("Queue is Emptpy");
		}
		return myQueue.remove();
	}

}
