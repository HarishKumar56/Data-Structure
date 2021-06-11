package org.nagarro.logic.Iterators;

import java.util.Iterator;

import org.nagarro.logic.MyQueueImpl;
import org.nagarro.logic.nodes.GenericNode;

public class MyTreeIteratorBFS<T> implements Iterator<GenericNode<T>> {

	private MyQueueImpl<GenericNode<T>> myQueue ;
	
	
	
	public MyTreeIteratorBFS(GenericNode<T> node) {
		myQueue = new MyQueueImpl<>();
		if(node != null) {
			myQueue.enqueue(node);
		}
	}

	@Override
	public boolean hasNext() {
		if(myQueue.size()>0) {
			return true;
		}
		return false;
	}

	@Override
	public GenericNode<T> next() {
		while(myQueue.size()>0) {
			GenericNode<T> tempNode = myQueue.dequeue();
			
			for(GenericNode<T> node : tempNode.treeChild) {
				if(node!=null) {
					myQueue.enqueue(node);
				}
				
			}
			return tempNode;
		}
		return null;
	}

}
