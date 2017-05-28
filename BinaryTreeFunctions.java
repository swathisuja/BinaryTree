package com.binary.tree;

import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeFunctions {

	// Insert
	Node ins(Node root, int key) {
		/* Inserts element to the root node */
		if (root == null) {
			root = new Node(key);
			return root;
		}
		/* Recursively inserts element to the left node */
		if (root.data > key) {
			root.left = ins(root.left, key);
		}
		/* Recursively inserts element to the right node */
		else if (root.data < key) {
			root.right = ins(root.right, key);
		}
		return root;
	}

	// Search
	public Node search(Node root, int key) {
		/* Searches inside the tree */
		while (root.data != key) {
			if (root != null) {
				if (root.data > key) {
					root = root.left;
				} else {
					root = root.right;
				}
				/* Element not in the tree */
				if (root == null) {
					return null;
				}
			}
		}
		return root;
	}

	// Delete
	Node del(Node root, int key, boolean print) {
		boolean temp = print;
		/* Element not in the tree */
		if (root == null) {
			System.out.println("!!!!!The given element is not in tree!!!!!");
			return root;
		}
		/* Recursively searches the left node to delete the given element */
		if (key < root.data) {
			root.left = del(root.left, key, temp);
		}
		/* Recursively searches the right node to delete the given element */
		else if (key > root.data) {
			root.right = del(root.right, key, temp);
		}
		/*
		 * Deletes the root element and replaces the root with inorder successor
		 */
		else {
			if (root.left == null) {
				if (print) {
					printDelInfo();
				}
				return root.right;
			} else if (root.right == null) {
				if (print) {
					printDelInfo();
				}
				return root.left;
			}
			root.data = minValue(root.right);
			printDelInfo();
			root.right = del(root.right, root.data, false);
		}
		return root;
	}

	private void printDelInfo() {
		System.out.println("*****Element deleted successfully*****");
	}

	int minValue(Node root) {
		int minv = root.data;
		while (root.left != null) {
			minv = root.left.data;
			root = root.left;
		}
		return minv;
	}

	// Inorder traversal print
	void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	// Levelorder traversal print
	void Level(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();
			System.out.print(tempNode.data + " ");
			/* Enqueue left child */
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}
			/* Enqueue right child */
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
		System.out.println();
	}
}
