package org.nagarro.presentation.handler;

import org.nagarro.presentation.handler.interfaces.UserHandler;

public class LinkedListHandler implements UserHandler {

	@Override
	public void messageHandler() {
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("Select the Opation number from the following Operations");
		System.out.println("1.  Insert\t\t2.  Insert at Position\t3.  Delete");
		System.out.println("4.  Delete at Position\t5.  Center\t\t6.  Reverse");
		System.out.println("7.  Size\t\t8.  Iterator\t\t9.  Traverse");
		System.out.println("10. Exit");
		System.out.println("----------------------------------------------------------------------------------------");
	}

	@Override
	public void handler() {
		// TODO Auto-generated method stub

	}

}
