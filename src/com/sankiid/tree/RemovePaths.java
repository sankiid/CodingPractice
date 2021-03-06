package com.sankiid.tree;

/**
 * Remove all path whose sum in less than k.
 * 
 * @author Sandeep
 * 
 */
public class RemovePaths {

	public static void main(String[] args) {
		Node<Integer> root = new Node<>(6);
		root.left = new Node<>(2);
		root.right = new Node<>(14);
		root.left.left = new Node<>(1);
		root.left.right = new Node<>(5);
		root.right.left = new Node<>(10);
		print(root);
		removePath(root, 14, new int[] { 0 });
		System.out.println();
		print(root);
	}

	private static Node<Integer> removePath(Node<Integer> root, int k, int[] sum) {
		if (root == null)
			return null;
		int[] ls = new int[1];
		int[] rs = new int[1];
		ls[0] = rs[0] = sum[0] + root.data;
		root.left = removePath(root.left, k, ls);
		root.right = removePath(root.right, k, rs);
		sum[0] = Math.max(ls[0], rs[0]);
		if (sum[0] < k) {
			return null;
		}
		return root;
	}

	static void print(Node<Integer> root) {
		if (root == null)
			return;
		print(root.left);
		System.out.printf("%d ", root.data);
		print(root.right);
	}

}
