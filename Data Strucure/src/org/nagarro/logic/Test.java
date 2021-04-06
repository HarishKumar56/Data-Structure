package org.nagarro.logic;

import org.nagarro.logic.nodes.HashNode;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHashMap<Integer, String> ans = new MyHashMap<>();
		ans.put(1, "harish");
		ans.put(2, "harifagdsfsh");
		ans.put(3, "hdsafdfarish");
		ans.put(4, "hadsadsrish");
		ans.put(5, "hdsvadsarish");
		ans.put(6, "Hello");
		System.out.println(ans.size());
		
		//ans.traverse();
		System.out.println(ans.contains(1));
		System.out.println(ans.contains(2));
		System.out.println(ans.contains(3));
		ans.traverse();
		for(HashNode<Integer, String> val : ans) {
			System.out.println(val.getKey()+"  "+val.getValue());
		}
		System.out.println(ans.size());
		ans.put(7, "harish");
		ans.put(8, "harifagdsfsh");
		ans.put(9, "hdsafdfarish");
		for(HashNode<Integer, String> val : ans) {
			System.out.println(val.getKey()+"  "+val.getValue());
		}
		ans.put(14, "hadsadsrish");
		ans.put(15, "hdsvadsarish");
		ans.put(16, "Hello");

		for(HashNode<Integer, String> val : ans) {
			System.out.println(val.getKey()+"  "+val.getValue());
		}
		ans.remove(1);
		ans.remove(2);
		ans.remove(3);
		ans.traverse();
		for(HashNode<Integer, String> val : ans) {
			System.out.println(val.getKey()+"  "+val.getValue());
		}
		ans.remove(6);
		ans.remove(5);
		ans.traverse();
		for(HashNode<Integer, String> val : ans) {
			System.out.println(val.getKey()+"  "+val.getValue());
		}

	}

}
