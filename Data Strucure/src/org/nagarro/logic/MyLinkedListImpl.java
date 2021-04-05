package org.nagarro.logic;

import java.util.Iterator;

import org.nagarro.logic.Iterators.MyLinkedListIterator;
import org.nagarro.logic.interfaces.MyLinkedList;

public class MyLinkedListImpl<T> implements MyLinkedList<T> {
	
	private LinkedListNode head;
	private LinkedListNode tail;
	private int size;
	
	public MyLinkedListImpl() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public MyLinkedListImpl(T data) {
		LinkedListNode node = new LinkedListNode(data);
		this.head = node;
		this.tail = node;
		this.size = 1;
	}
	
	public class LinkedListNode {
		
		private LinkedListNode nextNode;
		private LinkedListNode prevNode;
		private T data ;
		public LinkedListNode(T data) {
			this.nextNode = null;
			this.data = data;
			this.prevNode = null;
		}
		public LinkedListNode getNextNode() {
			return nextNode;
		}
		public void setNextNode(LinkedListNode nextNode) {
			this.nextNode = nextNode;
		}
		public LinkedListNode getPrevNode() {
			return prevNode;
		}
		public void setPrevNode(LinkedListNode prevNode) {
			this.prevNode = prevNode;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		
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
			LinkedListNode node = new LinkedListNode(data);
			this.head = node;
			this.tail = node;
			this.size++;			
		}
		else {
			LinkedListNode node = new LinkedListNode(data);
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
		LinkedListNode curr = head;
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
		
		LinkedListNode curr = head;
		LinkedListNode temp = null;
		
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
		LinkedListNode curr = head;
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
		LinkedListNode curr = head;
		LinkedListNode currJumped = head;
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
		LinkedListNode curr = head;
		while(position >0) {
			curr = curr.getNextNode();
			position--;
		}
		LinkedListNode newNode = new LinkedListNode(data);
		LinkedListNode prev = curr.getPrevNode();
		prev.setNextNode(newNode);
		newNode.setPrevNode(prev);
		newNode.setNextNode(curr);
		curr.setPrevNode(newNode);	
		size++;
		return true;
	}
	
	public boolean addFirst(T data) {
		LinkedListNode newNode = new LinkedListNode(data);
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
		LinkedListNode curr = tail;
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
		LinkedListNode curr = head;
		while(position >0) {
			curr = curr.getNextNode();
			position--;
		}
		LinkedListNode prev = curr.getPrevNode();
		LinkedListNode next = curr.getNextNode();
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
