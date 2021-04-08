package org.nagarro.logic;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyPriorityQueue<Integer> ans = new MyPriorityQueue<>();
		
		ans.add(10);
		ans.add(5);
		ans.add(1);
		ans.add(20);
		ans.add(30);
		ans.traverse();
		System.out.println(ans.contains(6));
		System.out.println(ans.remove());
		ans.traverse();
		System.out.println(ans.remove());
		ans.traverse();
		System.out.println(ans.remove());
		ans.traverse();
		System.out.println(ans.remove());
		ans.traverse();
		System.out.println(ans.remove());
		ans.traverse();
		System.out.println(ans.remove());
		ans.traverse();

	}

}
