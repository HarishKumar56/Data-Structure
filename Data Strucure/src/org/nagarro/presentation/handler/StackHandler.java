package org.nagarro.presentation.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.nagarro.logic.MyStackImpl;
import org.nagarro.logic.interfaces.MyStack;
import org.nagarro.presentation.handler.interfaces.UserHandler;

public class StackHandler implements UserHandler {

	private MyStack<Object> myStack;
	private BufferedReader br;

	public StackHandler() {
		myStack = new MyStackImpl<>();
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	@Override
	public void messageHandler() {
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("Select the Opation number from the following Operations");
		System.out.println("1.  Push\t\t2.  Pop\t\t\t3.  Peek");
		System.out.println("4.  Contains\t\t5.  Reverse\t\t6.  Size");
		System.out.println("7.  Iterator\t\t8.  Traverse\t\t9.  Exit");
		System.out.println("----------------------------------------------------------------------------------------");
	}

	@Override
	public void handler() {
		try {
			while (true) {
				messageHandler();
				int choice = Integer.parseInt(br.readLine());
				switch (choice) {
				case 1:
					System.out.print("Enter the Data to Push : ");
					myStack.push(br.readLine());
					break;
				case 2:
					System.out.println("Poped Element is : " + myStack.pop());
					break;
				case 3:
					System.out.println("Peek Element is : " + myStack.peek());
					break;
				case 6:
					System.out.println("Size of Stack is : " + myStack.size());
					break;
				case 5:
					myStack.reverse();
					System.out.println("Stack is reversed ");
					break;
				case 7:
					System.out.println("Iterator on Stack :");
					for (Object val : myStack) {
						System.out.println(val);
					}
					break;

				case 8:
					myStack.traverse();
					System.out.println();
					break;
				case 4:
					System.out.print("Enter the Element to check  :");
					if (myStack.contains(br.readLine())) {
						System.out.println("Element Exists in the Stack");
					} else {
						System.out.println("Element does not Exists in the Stack");
					}
					break;
				case 9:
					return;

				default:
					System.out.println("Enter the Valid Choice");
					handler();
					return;
				}
			}
		} catch (NumberFormatException | IOException e) {
			System.out.println("Enter the Valid Integer Value");
			handler();
			return;
		} catch (IllegalStateException ex) {
			System.out.println(ex.getMessage());
			handler();
			return;

		}

	}

}
