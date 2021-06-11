package org.nagarro.logic.Iterators;

import java.util.Iterator;

import org.nagarro.logic.MyQueueImpl;
import org.nagarro.logic.MyStackImpl;
import org.nagarro.logic.interfaces.MyStack;
import org.nagarro.logic.nodes.GenericNode;

public class MyTreeIteratorDFS<T> implements Iterator<GenericNode<T>> {
	
	private MyStack<Pair> myStack;
	class Pair{
		GenericNode<T> node;
		int state;
		public Pair(GenericNode<T> node, int state) {
			super();
			this.node = node;
			this.state = state;
		}	
	}
	
	public MyTreeIteratorDFS(GenericNode<T> node) {
		myStack = new MyStackImpl<>();
		if(node != null) {
			myStack.push(new Pair(node, -1));
		}
	}

	@Override
	public boolean hasNext() {
		if(myStack.size()>0) {
			return true;
		}
		return false;
	}

	@Override
	public GenericNode<T> next() {
		
		while(myStack.size()>0) {
			Pair top = myStack.peek();
			if(top.state ==-1) {
				top.state++;
			}
			else if(top.node.treeChild.length == top.state) {
				return myStack.pop().node;
			}
			else {
				if(top.node.treeChild[top.state] != null) {
					myStack.push(new Pair(top.node.treeChild[top.state] , -1));					
				}
				top.state++;
			}
		}
		return null;
	}

}
