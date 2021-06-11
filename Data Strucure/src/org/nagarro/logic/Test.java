package org.nagarro.logic;

import org.nagarro.logic.nodes.GenericNode;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyGenericTreeImpl<Object> ans = new  MyGenericTreeImpl<>(3);
		ans.add(1, null);
		ans.add(2,1);
		ans.add(7,2);
		ans.add(10,7);
		ans.add(9,7);
		ans.add(8,7);
		ans.add(6,2);
		ans.add(3,1);
		ans.add(5,3);
		ans.add(5,6);
		ans.add(11,5);
		ans.add(12,5);
		ans.add(13,5);
		ans.traverseBFS();
		System.out.println();
		ans.traverseBFS();
		System.out.println();
		System.out.println(ans.contains(5));
		System.out.println(ans.contains(7));
		System.out.println(ans.contains(70));
		ans.traverseBFS();
		System.out.println();
		ans.traverseDFS();
		for(GenericNode<Object> val : ans) {
			System.out.println(val.getData());
		}
		
		
	}

}
