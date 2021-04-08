package org.nagarro.logic.Iterators;

import java.util.Iterator;

import org.nagarro.logic.MyStackImpl;
import org.nagarro.logic.interfaces.MyStack;
import org.nagarro.logic.nodes.TreeNode;

public class MyQueueMinIterator<T> implements Iterator<T> {

	private MyStack<TreeNode<T>> myStack;
	private TreeNode<T> node;
	
	
	public MyQueueMinIterator(TreeNode<T> node) {
		super();
		this.node = node;
		this.myStack = new MyStackImpl<>();
	}

	@Override
	public boolean hasNext() {
		if(myStack.size()>0 || node != null) {
			return true;
		}
		return false;
	}

	@Override
	public T next() {
		
		while(node !=null || myStack.size()>0) {
			
			while(node!=null) {
				myStack.push(node);
				node = node.getlChild();
			}
			node = myStack.pop();
			TreeNode<T> tempNode = node;
			node = node.getrChild();
			return tempNode.getData();
			
		}
		return null;
		
	}

}
