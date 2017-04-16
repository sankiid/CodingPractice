package com.sankiid.tree;

/**
 * Created by sandeep on 17/2/17.
 */
public class HeightBalanced {
	public static void main(String[] args) {
		Node<Integer> root = new Node<>(6);
		root.left = new Node<>(2);
		root.right = new Node<>(4);
		root.left.left = new Node<>(1);
		root.left.left.left = new Node<>(5);

		root.right.left = new Node<>(7);
		root.right.right = new Node<>(3);
		root.right.right.left = new Node<>(11);

		boolean bool = isHeightBalanced(root);
		System.out.println(bool);

		root = new Node<>(6);
		root.left = new Node<>(2);
		root.right = new Node<>(4);
		root.left.left = new Node<>(10);
		root.left.right = new Node<>(11);
		root.right.left = new Node<>(40);
		printKDistanceNode(root, 2);
	}

	private static void printKDistanceNode(Node<Integer> root, int k) {
		if (root == null)
			return;
		if (k < 0)
			return;
		if (k == 0)
			System.out.print(root.data + " ");
		printKDistanceNode(root.left, k - 1);
		printKDistanceNode(root.right, k - 1);
	}

	private static boolean isHeightBalanced(Node<Integer> root) {
		boolean[] bool = new boolean[1];
		bool[0] = true;
		isHeightBalanced(root, bool);
		return bool[0];
	}

	private static int isHeightBalanced(Node<Integer> root, boolean[] bool) {
		if (root == null) {
			bool[0] = bool[0] && true;
			return 0;
		}
		if (root.left == null && root.right == null) {
			bool[0] = bool[0] && true;
			return 1;
		}
		int left = isHeightBalanced(root.left, bool);
		int right = isHeightBalanced(root.right, bool);
		if (Math.abs(left - right) > 1) {
			bool[0] = false;
		} else {
			bool[0] = bool[0] && true;
		}
		return Math.max(left, right) + 1;
	}
}
