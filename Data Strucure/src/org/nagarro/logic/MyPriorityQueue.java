package org.nagarro.logic;

import java.util.Iterator;

import org.nagarro.logic.Iterators.MyQueueMaxIterator;
import org.nagarro.logic.Iterators.MyQueueMinIterator;
import org.nagarro.logic.interfaces.MyQueue;
import org.nagarro.logic.nodes.TreeNode;

public class MyPriorityQueue<T extends Comparable<T>> implements MyQueue<T> {

	private TreeNode<T> rootNode;
	private int size;
	private int reverse;
	private T max;
	private T min;

	public MyPriorityQueue() {
		this.rootNode = null;
		this.size = 0;
	}

	@Override
	public Iterator<T> iterator() {
		if(rootNode == null) {
			throw new IllegalStateException("Priority Queue is Empty");
		}
		if(reverse%2 ==0) {
			return new MyQueueMinIterator<>(rootNode);
		}
		else {
			return new MyQueueMaxIterator<>(rootNode);
		}
	}

	@Override
	public boolean add(T data) {
		size++;
		if (rootNode == null) {
			rootNode = new TreeNode<T>(data);
			max = data;
			min = data;
			return true;
		}

		TreeNode<T> tempNode = rootNode;
		TreeNode<T> prevNode = null;
		while (tempNode != null) {
			prevNode = tempNode;
			if (tempNode.getData().compareTo(data) < 0) {
				tempNode = tempNode.getrChild();
			} else {
				tempNode = tempNode.getlChild();
			}
		}
		if (prevNode.getData().compareTo(data) < 0) {
			prevNode.setrChild(new TreeNode<T>(data));
		} else {
			prevNode.setlChild(new TreeNode<T>(data));
		}
		setMax();
		setMin();
		balance();
		return true;
	}

	@Override
	public T remove() {
		if(reverse%2 ==0) {
			return removeMin();
		}
		else {
			return removeMax();
		}
		
		
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void traverse() {
		if(rootNode == null) {
			throw new IllegalStateException("Priority Queue is Empty");
		}
		if(reverse%2 ==0) {
			traverseMin(rootNode);
		}
		else {
			traverseMax(rootNode);
		}
		System.out.println();

	}

	public void traverseMin(TreeNode<T> node) {
		if (node == null) {
			return;
		}
		traverseMin(node.getlChild());
		System.out.print(node.getData() + "   ");
		traverseMin(node.getrChild());

	}
	
	public void traverseMax(TreeNode<T> node) {
		if (node == null) {
			return;
		}
		traverseMax(node.getrChild());
		System.out.print(node.getData() + "   ");
		traverseMax(node.getlChild());

	}

	@Override
	public boolean enqueue(T data) {
		return add(data);
	}

	@Override
	public T dequeue() {
		return remove();
	}
	
	public T removeMin() {
		if(rootNode == null) {
			throw new IllegalStateException("Priority Queue is Empty");
		}
		TreeNode<T> tempNode = rootNode;
		TreeNode<T> prevNode = null;
		while(tempNode.getlChild() != null) {
			prevNode = tempNode;
			tempNode = tempNode.getlChild();
		}
		size--;
		if(prevNode == null) {
			prevNode = rootNode;
			rootNode = rootNode.getrChild();
			return prevNode.getData();
		}
		prevNode.setlChild(tempNode.getrChild());
		setMin();
		balance();
		return tempNode.getData();
	}
	
	public void setMin() {
		TreeNode<T> tempNode = rootNode;
		while(tempNode.getlChild()!= null) {
			tempNode = tempNode.getlChild();
		}
		min = tempNode.getData();
	}
	
	public void setMax() {
		TreeNode<T> tempNode = rootNode;
		while(tempNode.getrChild()!= null) {
			tempNode = tempNode.getrChild();
		}
		max = tempNode.getData();
	}
	
	public T removeMax() {
		if(rootNode == null) {
			throw new IllegalStateException("Priority Queue is Empty");
		}
		TreeNode<T> tempNode = rootNode;
		TreeNode<T> prevNode = null;
		while(tempNode.getrChild() != null) {
			prevNode = tempNode;
			tempNode = tempNode.getrChild();
		}
		size--;
		if(prevNode == null) {
			prevNode = rootNode;
			rootNode = rootNode.getlChild();
			return prevNode.getData();
		}
		prevNode.setrChild(tempNode.getlChild());
		setMax();
		balance();
		return tempNode.getData();
	}

	@Override
	public T peek() {
		if(rootNode == null) {
			throw new IllegalStateException("Priority Queue is Empty");
		}
		if(reverse%2 ==0) {
			return min;
		}
		else {
			return max;
		}
	}

	@Override
	public boolean contains(T data) {
		if (rootNode == null) {
			throw new IllegalStateException("Priority Queue is Empty");
		}
		TreeNode<T> tempNode = rootNode;
		while (tempNode != null) {
			if (tempNode.getData().compareTo(data) == 0) {
				return true;
			} else if (tempNode.getData().compareTo(data) < 0) {
				tempNode = tempNode.getrChild();
			} else if (tempNode.getData().compareTo(data) > 0) {
				tempNode = tempNode.getlChild();
			}
			else {
				break;
			}
		}
		return false;
	}

	@Override
	public void reverse() {
		reverse++;
	}

	public int balanceFactor(TreeNode<T> node) {
		if(node == null) {
			return 0;
		}
		return height(node.getlChild()) - height(node.getrChild());
	}

	public int getBalance() {
		return balanceFactor(rootNode);
	}

	public void balance() {
		int bfactor = balanceFactor(rootNode);
		if(bfactor>1) {
			TreeNode<T> tempNode = rootNode.getlChild();
			int childBFactor = balanceFactor(tempNode);
			if(childBFactor<-1) {
				tempNode = leftRotation(tempNode);
				rootNode.setlChild(tempNode);
			}
			rootNode = rightRotation(rootNode);
			
		}
		else if(bfactor<-1) {
			TreeNode<T> tempNode = rootNode.getrChild();
			int childBFactor = balanceFactor(tempNode);
			if(childBFactor>1) {
				tempNode = rightRotation(tempNode);
				rootNode.setrChild(tempNode);
			}
			rootNode = leftRotation(rootNode);
			
		}
	}
	
	public TreeNode<T> rightRotation(TreeNode<T> node){
		TreeNode<T> tempNode = node;
		node = node.getlChild();
		tempNode.setlChild(node.getrChild());
		node.setrChild(tempNode);
		return node;
	}
	
	public TreeNode<T> leftRotation(TreeNode<T> node){
		TreeNode<T> tempNode = node;
		node = node.getrChild();
		tempNode.setrChild(node.getlChild());
		node.setlChild(tempNode);
		return node;
	}

	public int height(TreeNode<T> node) {
		if(node == null) {
			return -1;
		}
		
		return 1+ Math.max(height(node.getrChild()) , height(node.getlChild()));
	}
}
