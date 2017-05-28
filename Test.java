package com.binary.tree;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		BinaryTreeFunctions bin = new BinaryTreeFunctions();
		Node root = null, end = null;
		int ch = 0, num = 0;
		Scanner s = new Scanner(System.in);
		do {
			System.out.printf(
					"\nOPTIONS\n1.Insert\n2.Delete\n3.Search\n4.Level Order Display\n5.Inorder Display\n6.Exit\nChoice:");

			ch = s.nextInt();
			try {
				switch (ch) {
				case 1:
					System.out.println("Enter the number to be inserted:");
					num = s.nextInt();
					root = bin.ins(root, num);
					break;
				case 2:
					if (root != null) {
						System.out.println("Enter the number to be deleted:");
						num = s.nextInt();
						root = bin.del(root, num, true);
					} else {
						System.out.println("!!!!!Tree is empty!!!!!");
					}
					break;
				case 3:
					if (root != null) {
						System.out.println("Enter the number to be searched:");
						num = s.nextInt();
						end = bin.search(root, num);
						if (end != null) {
							System.out.println("*****Element found*****");
						} else {
							System.out.println("!!!!!Element not in tree!!!!!");
						}
					} else {
						System.out.println("!!!!!Tree is empty!!!!!");
					}
					break;
				case 4:
					if (root != null) {
						System.out.println("*****Level order traversal*****");
						bin.Level(root);
					} else {
						System.out.println("!!!!!Tree is empty!!!!!");
					}
					break;
				case 5:
					if (root != null) {
						System.out.println("*****Inorder traversal*****");
						bin.inorder(root);
					} else {
						System.out.println("!!!!!Tree is empty!!!!!");
					}
					break;
				case 6:
					break;
				default:
					System.out.println("!!!!!Invalid option entered!!!!!");
				}
			} catch (Exception e) {
				System.out.println("!!!!!Oops something went wrong.Please enter valid input!!!!!!");
				s.nextLine();
			}
		} while (ch != 6);
		System.out.println("THANK YOU!!!");
	}

}
