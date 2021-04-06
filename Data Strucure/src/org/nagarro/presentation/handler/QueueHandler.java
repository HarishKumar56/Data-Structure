package org.nagarro.presentation.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.nagarro.logic.MyQueueImpl;
import org.nagarro.logic.interfaces.MyQueue;
import org.nagarro.presentation.handler.interfaces.UserHandler;

public class QueueHandler implements UserHandler {

	private MyQueue<Object> myQueue;
	private BufferedReader br;

	public QueueHandler() {
		myQueue = new MyQueueImpl<>();
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	@Override
	public void messageHandler() {
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("Select the Opation number from the following Operations");
		System.out.println("1.  Enqueue\t\t2.  Dequeue\t\t3.  Peek");
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
					System.out.print("Enter the Data to Insert : ");
					myQueue.enqueue(br.readLine());
					break;
				case 2:
					System.out.println("Delted Element is : " + myQueue.dequeue());
					break;
				case 3:
					System.out.println("Peek Element is : " + myQueue.peek());
					break;
				case 6:
					System.out.println("Size of Queue is : " + myQueue.size());
					break;
				case 5:
					myQueue.reverse();
					System.out.println("Queue is reversed ");
					break;
				case 7:
					System.out.println("Iterator on Queue :");
					for (Object val : myQueue) {
						System.out.println(val);
					}
					break;

				case 8:
					myQueue.traverse();
					System.out.println();
					break;
				case 4:
					System.out.print("Enter the Element to check  :");
					if (myQueue.contains(br.readLine())) {
						System.out.println("Element Exists in the Queue");
					} else {
						System.out.println("Element does not Exists in the Queue");
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
