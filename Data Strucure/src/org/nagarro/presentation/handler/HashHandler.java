package org.nagarro.presentation.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.nagarro.logic.MyHashMap;
import org.nagarro.logic.interfaces.MyHash;
import org.nagarro.logic.nodes.HashNode;
import org.nagarro.presentation.handler.interfaces.UserHandler;

public class HashHandler implements UserHandler {

	private BufferedReader br;
	MyHash<Object, Object> myHash;

	public HashHandler() {
		myHash = new MyHashMap<>();
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	@Override
	public void messageHandler() {
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("Select the Opation number from the following Operations");
		System.out.println("1.  Put\t\t\t2.  Remove\t\t3.  get");
		System.out.println("4.  Contains\t\t5.  Traverse\t\t6.  Size");
		System.out.println("7.  Iterator\t\t8.  Exit");
		System.out.println("----------------------------------------------------------------------------------------");
	}

	@Override
	public void handler() {
		try {
			while (true) {
				messageHandler();
				int choice = Integer.parseInt(br.readLine());
				Object key, value;
				switch (choice) {
				case 1:
					System.out.print("Enter the Key : ");
					key = br.readLine();
					System.out.print("Enter the Value : ");
					value = br.readLine();
					myHash.put(key, value);
					break;
				case 2:
					System.out.println("Enter the Key to Delete: ");
					key = br.readLine();
					myHash.remove(key);
					break;
				case 3:
					System.out.println("Enter the Key to get Value: ");
					key = br.readLine();
					value = myHash.get(key);
					System.out.println("Value of Key (" + key + ") : " + value);
					break;
				case 6:
					System.out.println("Size of Hash is : " + myHash.size());
					break;
				case 5:
					myHash.traverse();
					break;
				case 7:
					System.out.println("Iterator on Hash :");
					for (HashNode<Object, Object> val : myHash) {
						System.out.println(val.getKey() + " : " + val.getValue());
					}
					break;

				case 8:
					return;
				case 4:
					System.out.print("Enter the Key to check  :");
					if (myHash.contains(br.readLine())) {
						System.out.println("Element Exists in the Hash");
					} else {
						System.out.println("Element does not Exists in the Hash");
					}
					break;

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
