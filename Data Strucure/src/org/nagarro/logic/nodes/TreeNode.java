package org.nagarro.logic.nodes;

public class TreeNode<T> {
	
	private TreeNode<T> lChild;
	
	private TreeNode<T> rChild;
	
	private T data;

	public TreeNode(T data) {
		super();
		this.data = data;
		this.lChild = null;
		this.rChild = null;
	}
	

	public TreeNode<T> getlChild() {
		return lChild;
	}

	public void setlChild(TreeNode<T> lChild) {
		this.lChild = lChild;
	}

	public TreeNode<T> getrChild() {
		return rChild;
	}

	public void setrChild(TreeNode<T> rChild) {
		this.rChild = rChild;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	
	
	

}
