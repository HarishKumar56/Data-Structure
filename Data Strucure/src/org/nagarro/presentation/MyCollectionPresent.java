package org.nagarro.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.nagarro.presentation.handler.HashHandler;
import org.nagarro.presentation.handler.LinkedListHandler;
import org.nagarro.presentation.handler.PriorityQueueHandler;
import org.nagarro.presentation.handler.QueueHandler;
import org.nagarro.presentation.handler.StackHandler;
import org.nagarro.presentation.handler.interfaces.UserHandler;

public class MyCollectionPresent {

	private BufferedReader br;
	private UserHandler userHandler;

	public static void main(String[] args) throws NumberFormatException, IOException {

		MyCollectionPresent myPresent = new MyCollectionPresent();
		myPresent.handler();

	}

	private void handler() throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while (true) {
				showDataStructures();
				int num = Integer.parseInt(br.readLine());
				switch (num) {
				case 1:
					userHandler = new LinkedListHandler();
					userHandler.handler();
					break;
				case 2:
					userHandler = new StackHandler();
					userHandler.handler();
					break;
				case 3:
					userHandler = new QueueHandler();
					userHandler.handler();
					break;
				case 4:
					userHandler = new HashHandler();
					userHandler.handler();
					break;
				case 5:
					userHandler = new PriorityQueueHandler();
					userHandler.handler();
					break;
				case 7:
					return;
				default:
					System.out.println("Invalid Input. Re-enter your response");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid Input. Enter Integer value only");
			handler();
			return;
		} finally {
			br.close();
		}
	}

	private void showDataStructures() {
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("Select the Data Structure number from the following Data Structure");
		System.out.println("1.  LinkedList");
		System.out.println("2.  Stack");
		System.out.println("3.  Queue");
		System.out.println("4.  Hash");
		System.out.println("5.  Priority Queue");
		System.out.println("7.  Exit");
		System.out.println("----------------------------------------------------------------------------------------");

	}

}
