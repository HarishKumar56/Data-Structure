package org.nagarro.logic.nodes;


public class LinkedListNode<T> {
	private LinkedListNode<T> nextNode;
	private LinkedListNode<T> prevNode;
	private T data ;
	public LinkedListNode(T data) {
		this.nextNode = null;
		this.data = data;
		this.prevNode = null;
	}
	public LinkedListNode<T> getNextNode() {
		return nextNode;
	}
	public void setNextNode(LinkedListNode<T> nextNode) {
		this.nextNode = nextNode;
	}
	public LinkedListNode<T> getPrevNode() {
		return prevNode;
	}
	public void setPrevNode(LinkedListNode<T> prevNode) {
		this.prevNode = prevNode;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	

}
