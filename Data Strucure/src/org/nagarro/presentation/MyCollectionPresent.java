package org.nagarro.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.nagarro.logic.MyLinkedListImpl;
import org.nagarro.logic.MyQueueImpl;
import org.nagarro.logic.MyStackImpl;
import org.nagarro.logic.interfaces.MyLinkedList;
import org.nagarro.logic.interfaces.MyQueue;
import org.nagarro.logic.interfaces.MyStack;

public class MyCollectionPresent {
	
	private BufferedReader br;
	private MyLinkedList<Object> myList;
	private MyStack<Object> myStack;
	private MyQueue<Object> myQueue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		MyCollectionPresent myPresent = new MyCollectionPresent();
		myPresent.handler();

	}

	private void handler() throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(true) {
				showDataStructures();
				int num = Integer.parseInt(br.readLine());
				switch (num) {
				case 1:
					myList = new MyLinkedListImpl<Object>();
					linkListHandler();
					break;
				case 2:
					myStack = new MyStackImpl<>();
					stackHandler();
					break;
				case 3:
					myQueue = new MyQueueImpl<>();
					queueHandler();
					break;
				case 7:
					return;
				default:
					System.out.println("Invalid Input. Re-enter your response");
					break;
				}
			}			
		}
		catch(Exception e){
			System.out.println("Invalid Input. Enter Integer value only");
			handler();
			return;
		}
		finally {
			br.close();
		}
	}

	private void linkListMessageHandler() {
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("Select the Opation number from the following Operations");
		System.out.println("1.  Insert\t\t2.  Insert at Position\t3.  Delete");
		System.out.println("4.  Delete at Position\t5.  Center\t\t6.  Reverse");
		System.out.println("7.  Size\t\t8.  Iterator\t\t9.  Traverse");
		System.out.println("10. Exit");
		System.out.println("----------------------------------------------------------------------------------------");
	}
	
	private void queueMessageHandler() {
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("Select the Opation number from the following Operations");
		System.out.println("1.  Enqueue\t\t2.  Dequeue\t\t3.  Peek");
		System.out.println("4.  Contains\t\t5.  Reverse\t\t6.  Size");
		System.out.println("7.  Iterator\t\t8.  Traverse\t\t9.  Exit");
		System.out.println("----------------------------------------------------------------------------------------");
	}
	
	private void stackMessageHandler() {
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("Select the Opation number from the following Operations");
		System.out.println("1.  Push\t\t2.  Pop\t\t3.  Peek");
		System.out.println("4.  Contains\t\t5.  Reverse\t\t6.  Size");
		System.out.println("7.  Iterator\t\t8.  Traverse\t\t9.  Exit");
		System.out.println("----------------------------------------------------------------------------------------");
	}

	private void queueHandler() {
		try {
			while(true) {
				queueMessageHandler();
				int choice = Integer.parseInt(br.readLine());
				switch (choice) {
				case 1:
					System.out.print("Enter the Data to Insert : ");
					myQueue.enqueue(br.readLine());				
					break;
				case 2:
					System.out.println("Delted Element is : "+myQueue.dequeue());				
					break;
				case 3:
					System.out.println("Peek Element is : "+myQueue.peek());				
					break;
				case 6:
					System.out.println("Size of Queue is : "+myQueue.size());				
					break;
				case 5:
					myQueue.reverse();
					System.out.println("Queue is reversed ");				
					break;
				case 7:
					System.out.println("Iterator on Queue :");	
					for(Object val : myQueue) {
						System.out.println(val);
					}
					break;
				
				case 8:
					myQueue.traverse();	
					System.out.println();
					break;
				case 4:
					System.out.print("Enter the Element to check  :");	
					if(myQueue.contains(br.readLine())) {
						System.out.println("Element Exists in the Queue");	
					}
					else {
						System.out.println("Element does not Exists in the Queue");
					}
					break;
				case 9:
					return;

				default:
					System.out.println("Enter the Valid Choice");
					queueHandler();
					return;
				}
			}
		} catch (NumberFormatException | IOException e) {
			System.out.println("Enter the Valid Integer Value");
			queueHandler();	
			return;
		}
		catch(IllegalStateException ex) {
			System.out.println(ex.getMessage());
			queueHandler();
			return;
			
		}
		
	}

	private void stackHandler() {
		try {
			while(true) {
				stackMessageHandler();
				int choice = Integer.parseInt(br.readLine());
				switch (choice) {
				case 1:
					System.out.print("Enter the Data to Push : ");
					myStack.push(br.readLine());				
					break;
				case 2:
					System.out.println("Poped Element is : "+myStack.pop());				
					break;
				case 3:
					System.out.println("Peek Element is : "+myStack.peek());				
					break;
				case 6:
					System.out.println("Size of Stack is : "+myStack.size());				
					break;
				case 5:
					myStack.reverse();
					System.out.println("Stack is reversed ");				
					break;
				case 7:
					System.out.println("Iterator on Stack :");	
					for(Object val : myStack) {
						System.out.println(val);
					}
					break;
				
				case 8:
					myStack.traverse();	
					System.out.println();
					break;
				case 4:
					System.out.print("Enter the Element to check  :");	
					if(myStack.contains(br.readLine())) {
						System.out.println("Element Exists in the Stack");	
					}
					else {
						System.out.println("Element does not Exists in the Stack");
					}
					break;
				case 9:
					return;

				default:
					System.out.println("Enter the Valid Choice");
					stackHandler();
					return;
				}
			}
		} catch (NumberFormatException | IOException e) {
			System.out.println("Enter the Valid Integer Value");
			stackHandler();	
			return;
		}
		catch(IllegalStateException ex) {
			System.out.println(ex.getMessage());
			stackHandler();
			return;
			
		}
		
	}

	private void linkListHandler() {		
		try {
			int pos;
			while(true) {
				linkListMessageHandler();
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
					System.out.println("Delted Element is : "+myList.remove());				
					break;
				case 4:
					System.out.print("Enter the position of Data to Delete : ");
					pos = Integer.parseInt(br.readLine());
					System.out.println("Delted Element is : "+myList.remove(pos));					
					break;
				case 5:
					System.out.println("Center Element is : "+myList.center());				
					break;
				case 7:
					System.out.println("Size of Linked List is : "+myList.size());				
					break;
				case 6:
					myList.reverse();
					System.out.println("Linked List is reversed ");				
					break;
				case 8:
					System.out.println("Iterator on Linked List :");	
					for(Object val : myList) {
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
					linkListHandler();
					return;
				}
			}
		} catch (NumberFormatException | IOException e) {
			System.out.println("Enter the Valid Integer Value");
			linkListHandler();	
			return;
		}
		catch(IllegalStateException ex) {
			System.out.println(ex.getMessage());
			linkListHandler();
			return;
		}
		
	}

	private void showDataStructures() {
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("Select the Data Structure number from the following Data Structure");
		System.out.println("1.  LinkedList");
		System.out.println("2.  Stack");
		System.out.println("3.  Queue");
		System.out.println("7.  Exit");
		System.out.println("----------------------------------------------------------------------------------------");
		
	}

}
