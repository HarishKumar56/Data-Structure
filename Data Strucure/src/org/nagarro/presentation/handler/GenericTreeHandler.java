package org.nagarro.presentation.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.nagarro.logic.MyGenericTreeImpl;
import org.nagarro.logic.nodes.GenericNode;
import org.nagarro.presentation.handler.interfaces.UserHandler;

public class GenericTreeHandler implements UserHandler {

	private BufferedReader br;
	private MyGenericTreeImpl<Object> myTree;

	public GenericTreeHandler() throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the Capacity of Each child  :  ");
		int cap = Integer.parseInt(br.readLine());
		System.out.print("Enter the Value of Root Node  :  ");
		myTree = new MyGenericTreeImpl<>(cap);
		myTree.add(br.readLine(), null);

	}

	@Override
	public void messageHandler() {
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("Select the Opation number from the following Operations");
		System.out.println("1.  add\t\t\t2.  Remove\t\t3.  Get Element by Value");
		System.out.println("4.  Contains\t\t5.  Traverse BFS\t6.  Traverse DFS");
		System.out.println("7.  Iterator BFS\t8.  Iterate DFS\t\t9.  Get Elements by Level");
		System.out.println("10. Exit");
		System.out.println("----------------------------------------------------------------------------------------");

	}

	@Override
	public void handler() {
		try {
			while (true) {
				messageHandler();
				int choice = Integer.parseInt(br.readLine());
				Object parent, child;
				switch (choice) {
				case 1:
					System.out.print("Enter the Parent Node Value : ");
					parent = br.readLine();
					System.out.print("Enter the Current Node Value : ");
					child = br.readLine();
					if(myTree.contains(parent)) {
						myTree.add(child, parent);
					}
					else {
						System.out.println("Parent Does not Exists in Tree");
					}
					
					break;
				case 2:
					System.out.println("Enter the value of Node to Delete: ");
					parent = br.readLine();
					myTree.remove(parent);
					break;
				case 9:
					System.out.print("Enter the Level number: ");
					myTree.elementByLevel(Integer.parseInt(br.readLine()));
					System.out.println();
					break;
				case 3:
					System.out.println("Enter the node value to get Elements: ");
					parent = br.readLine();
					myTree.elementsByValue(parent);
					System.out.println();
					break;
				case 6:
					myTree.traverseDFS();
					System.out.println();
					break;
				case 5:
					myTree.traverseBFS();
					System.out.println();
					break;
				case 7:
					myTree.setIteratorType(0);
					System.out.println("BFS Iterator on Tree :");
					for (GenericNode<Object> val : myTree) {
						System.out.println(val.getData());
					}
					break;
				case 8:
					myTree.setIteratorType(1);
					System.out.println("DFS Iterator on Tree :");
					for (GenericNode<Object> val : myTree) {
						System.out.println(val.getData());
					}
					break;

				case 10:
					return;
				case 4:
					System.out.print("Enter the Node value to check  :");
					if (myTree.contains(br.readLine())) {
						System.out.println("Element Exists in the Tree");
					} else {
						System.out.println("Element does not Exists in the Tree");
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
