package org.nagarro.presentation.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.nagarro.logic.MyLinkedListImpl;
import org.nagarro.logic.interfaces.MyLinkedList;
import org.nagarro.presentation.handler.interfaces.UserHandler;

public class LinkedListHandler implements UserHandler {

	private MyLinkedList<Object> myList;
	private BufferedReader br;

	public LinkedListHandler() {
		myList = new MyLinkedListImpl<>();
		br = new BufferedReader(new InputStreamReader(System.in));
	}

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
		try {
			int pos;
			while (true) {
				messageHandler();
				int choice = Integer.parseInt(br.readLine());
				switch (choice) {
				case 1:
					System.out.print("Enter the Data to Insert : ");
					myList.add(br.readLine());
					break;
				case 2:
					System.out.print("Enter the position of Data to Insert : ");
					pos = Integer.parseInt(br.readLine());
					System.out.print("Enter the Data to Insert : ");
					myList.insert(pos, br.readLine());
					break;
				case 3:
					System.out.println("Delted Element is : " + myList.remove());
					break;
				case 4:
					System.out.print("Enter the position of Data to Delete : ");
					pos = Integer.parseInt(br.readLine());
					System.out.println("Delted Element is : " + myList.remove(pos));
					break;
				case 5:
					System.out.println("Center Element is : " + myList.center());
					break;
				case 7:
					System.out.println("Size of Linked List is : " + myList.size());
					break;
				case 6:
					myList.reverse();
					System.out.println("Linked List is reversed ");
					break;
				case 8:
					System.out.println("Iterator on Linked List :");
					for (Object val : myList) {
						System.out.println(val);
					}
					break;

				case 9:
					myList.traverse();
					System.out.println();
					break;
				case 10:
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
