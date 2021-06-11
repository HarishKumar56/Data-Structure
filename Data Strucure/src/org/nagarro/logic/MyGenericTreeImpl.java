package org.nagarro.logic;

import java.util.Iterator;

import org.nagarro.logic.Iterators.MyTreeIteratorBFS;
import org.nagarro.logic.Iterators.MyTreeIteratorDFS;
import org.nagarro.logic.interfaces.MyGenericTree;
import org.nagarro.logic.interfaces.MyQueue;
import org.nagarro.logic.nodes.GenericNode;

public class MyGenericTreeImpl<T> implements MyGenericTree<T> {

	private GenericNode<T> rootNode;
	private int childSize;
	
	private int iteratorType;
	public MyGenericTreeImpl(int childSize) {
		super();
		this.childSize = childSize;
		rootNode = null;
	}
	
	

	public void setIteratorType(int iteratorType) {
		this.iteratorType = iteratorType;
	}



	@Override
	public Iterator<GenericNode<T>> iterator() {
		// TODO Auto-generated method stub
		if(iteratorType ==0) {
			return new MyTreeIteratorBFS<T>(rootNode);
		}
		else {
			return new MyTreeIteratorDFS<T>(rootNode);
		}
		
	}

	@Override
	public boolean add(T data , T parentData) {
		// TODO Auto-generated method stub
		if(rootNode == null) {
			rootNode = new GenericNode<>(data , childSize);
			return true;
		}
		rootNode = add(rootNode , data , parentData );
		return true;
	}
	
	
	
	public GenericNode<T> add(GenericNode<T> node ,T data , T parentData){
		if(node.getData().equals(parentData)) {
			int i=0;
			while(i<childSize) {
				if(node.treeChild[i] == null) {
					break;
				}
				i++;
			}
			if(i == childSize) {
				throw new IllegalStateException("Capacity of child is full");
			}
			node.treeChild[i] = new GenericNode<>(data , childSize);
			return node;
		}
		for(int i=0 ; i<childSize ; i++) {
			if(node.treeChild[i] !=null) {
				node.treeChild[i] = add(node.treeChild[i] , data , parentData);
			}
		}
		return node;
	}
	
	public GenericNode<T> removeChild(GenericNode<T> node ,T data){
		if(node.getData().equals(data)) {
			node = null;
			return node;
		}
		for(int i=0 ; i<childSize ; i++) {
			if(node.treeChild[i] !=null) {
				node.treeChild[i] = removeChild(node.treeChild[i] , data );
			}
		}
		return node;
	}

	@Override
	public T remove(T data) {
		if(rootNode==null) {
			throw new IllegalStateException("Tree is Empty");
		}
		rootNode = removeChild(rootNode, data );
		return data;
	}

	@Override
	public boolean contains(T data) {
		if(rootNode==null) {
			throw new IllegalStateException("Tree is Empty");
		}
		return contains(rootNode , data , false);
	}
	
	public boolean contains(GenericNode<T> node ,T data , boolean result) {
		
		if(node.getData().equals(data)) {
			return true;
		}
		for(int i=0 ; i<childSize ; i++) {
			if(node.treeChild[i] !=null) {
				result = contains(node.treeChild[i] , data , result );
			}
		}
		return result;
	}
	
	public GenericNode<T> getNode(GenericNode<T> node ,T data , GenericNode<T> result) {
		
		if(node.getData().equals(data)) {
			return node;
		}
		for(int i=0 ; i<childSize ; i++) {
			if(node.treeChild[i] !=null) {
				result = getNode(node.treeChild[i] , data ,result );
			}
		}
		return result;
	}
	

	@Override
	public void traverseBFS() {
		if(rootNode==null) {
			throw new IllegalStateException("Tree is Empty");
		}
		traverseBFSHelper(rootNode);
		
	}
	public void traverseBFSHelper(GenericNode<T> nodeTemp) {
		MyQueue<GenericNode<T>> myQueue = new MyQueueImpl<>();
		MyQueue<GenericNode<T>> myQueueSupport = new MyQueueImpl<>();
		myQueue.enqueue(nodeTemp);
		while(myQueue.size()>0) {
			GenericNode<T> tempNode = myQueue.dequeue();
			System.out.print(tempNode.getData() +"   ");
			for(GenericNode<T> node : tempNode.treeChild) {
				if(node!=null) {
					myQueueSupport.enqueue(node);
				}
				
			}
			if(myQueue.size()==0) {
				myQueue = myQueueSupport;
				myQueueSupport = new MyQueueImpl<>();
				System.out.println();
			}
		}
		
	}

	@Override
	public void traverseDFS() {
		if(rootNode==null) {
			throw new IllegalStateException("Tree is Empty");
		}
		traverseDFSHelper(rootNode);	
	}
	public void traverseDFSHelper(GenericNode<T> node) {
		
		for(GenericNode<T> tempNode : node.treeChild) {
			if(tempNode != null) {
				
				traverseDFSHelper(tempNode);
			}
		}
		System.out.print(node.getData()+"   ");
	}



	@Override
	public void elementByLevel(int level) {
		int l =1;
		if(rootNode==null) {
			throw new IllegalStateException("Tree is Empty");
		}
		MyQueue<GenericNode<T>> myQueue = new MyQueueImpl<>();
		MyQueue<GenericNode<T>> myQueueSupport = new MyQueueImpl<>();
		myQueue.enqueue(rootNode);
		while(myQueue.size()>0) {
			GenericNode<T> tempNode = myQueue.dequeue();
			if(l == level) {
				System.out.print(tempNode.getData() +"   ");
			}			
			for(GenericNode<T> node : tempNode.treeChild) {
				if(node!=null) {
					myQueueSupport.enqueue(node);
				}
				
			}
			if(myQueue.size()==0) {
				myQueue = myQueueSupport;
				myQueueSupport = new MyQueueImpl<>();
				l++;
			}
		}
		
	}



	@Override
	public void elementsByValue(T data) {
		GenericNode<T> node = getNode(rootNode, data , null);
		if(node==null) {
			throw new IllegalStateException("Sub Tree with this value Does not Exists");
		}
		traverseBFSHelper(node);
		
	}


}
