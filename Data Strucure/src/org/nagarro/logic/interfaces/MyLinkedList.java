package org.nagarro.logic.interfaces;

public interface MyLinkedList<T> extends Iterable<T> {

	public boolean add(T data);

	public T remove();

	public int size();

	public void traverse();

	public boolean insert(int position, T data);

	public T remove(int position);

	public void reverse();

	public T center();

}
