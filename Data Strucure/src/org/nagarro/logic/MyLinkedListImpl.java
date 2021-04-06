package org.nagarro.logic;

import java.util.Iterator;

import org.nagarro.logic.Iterators.MyLinkedListIterator;
import org.nagarro.logic.interfaces.MyLinkedList;
import org.nagarro.logic.nodes.LinkedListNode;

public class MyLinkedListImpl<T> implements MyLinkedList<T> {
	
	private LinkedListNode<T> head;
	private LinkedListNode<T> tail;
	private int size;
	
	public MyLinkedListImpl() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public MyLinkedListImpl(T data) {
		LinkedListNode<T> node = new LinkedListNode<T>(data);
		this.head = node;
		this.tail = node;
		this.size = 1;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		MyLinkedListIterator<T> iterator = new MyLinkedListIterator<T>(head);
		return iterator;
	}

	@Override
	public boolean add(T data) {
		if(size == 0) {
			LinkedListNode<T> node = new LinkedListNode<T>(data);
			this.head = node;
			this.tail = node;
			this.size++;			
		}
		else {
			LinkedListNode<T> node = new LinkedListNode<T>(data);
			node.setPrevNode(tail);
			tail.setNextNode(node);
			tail = node;
			size++;
		}
		
		return true;
	}

	@Override
	public T remove() {
		if(size == 0) {
			throw new IllegalStateException("Linked List is Empty");
		}
		LinkedListNode<T> curr = head;
		head = curr.getNextNode();
		if(head !=null) {
			head.setPrevNode(null);
		}		
		size--;
		return curr.getData();		
	}

	@Override
	public void reverse() {
		if(size == 0) {
			throw new IllegalStateException("Linked List is Empty");
		}
		
		LinkedListNode<T> curr = head;
		LinkedListNode<T> temp = null;
		
		while(curr != null) {
			temp = curr.getPrevNode();
			curr.setPrevNode(curr.getNextNode());
			curr.setNextNode(temp);
			curr = curr.getPrevNode();
		}
		curr = tail;
		tail = head;
		head = curr;
		
		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void traverse() {
		if(size == 0) {
			throw new IllegalStateException("Linked List is Empty");
		}
		LinkedListNode<T> curr = head;
		System.out.print(curr.getData());
		while(curr.getNextNode() != null) {
			System.out.print("--->"+curr.getNextNode().getData());
			curr = curr.getNextNode();
		}
		
	}

	public T center() {
		if(size ==0) {
			throw new IllegalStateException("Linked List is Empty");
		}
		LinkedListNode<T> curr = head;
		LinkedListNode<T> currJumped = head;
		while(currJumped.getNextNode()!= null && currJumped.getNextNode().getNextNode()!=null) {
			curr = curr.getNextNode();
			currJumped = currJumped.getNextNode().getNextNode();
		}
		return curr.getData();
	}
	
	public boolean insert(int position , T data) {
		if(size() < position) {
			throw new IllegalStateException("Index of Insertion is Greater than Size of Linked List");
		}
		if(position == size()) {
			return add(data);
		}
		if(position ==0) {
			return addFirst(data);
		}
		LinkedListNode<T> curr = head;
		while(position >0) {
			curr = curr.getNextNode();
			position--;
		}
		LinkedListNode<T> newNode = new LinkedListNode<T>(data);
		LinkedListNode<T> prev = curr.getPrevNode();
		prev.setNextNode(newNode);
		newNode.setPrevNode(prev);
		newNode.setNextNode(curr);
		curr.setPrevNode(newNode);	
		size++;
		return true;
	}
	
	public boolean addFirst(T data) {
		LinkedListNode<T> newNode = new LinkedListNode<T>(data);
		if(size == 0) {
			this.head = newNode;
			this.tail = newNode;
			this.size++;			
		}
		else {
			newNode.setNextNode(head);
			head.setPrevNode(newNode);
			head = newNode;
			size++;			
		}
		
		return true;
	}

	public T removeLast() {
		if(size == 0) {
			throw new IllegalStateException("Linked List is Empty");
		}
		LinkedListNode<T> curr = tail;
		tail = tail.getPrevNode();
		if(tail !=null) {
			tail.setNextNode(null);
		}		
		size--;
		return curr.getData();		
	}

	public T remove(int position) {
		if(position > size()) {
			throw new IllegalStateException("Index of Removing is Greater than Size of Linked List");
		}
		if(position ==0) {
			return remove();
		}
		if(position == size()) {
			return removeLast();
		}
		LinkedListNode<T> curr = head;
		while(position >0) {
			curr = curr.getNextNode();
			position--;
		}
		LinkedListNode<T> prev = curr.getPrevNode();
		LinkedListNode<T> next = curr.getNextNode();
		prev.setNextNode(next);
		next.setPrevNode(prev);
		size--;
		return curr.getData();		
	}
	
	public T getHead() {
		return head.getData();
	}
	public T getTail() {
		return tail.getData();
	}
}
