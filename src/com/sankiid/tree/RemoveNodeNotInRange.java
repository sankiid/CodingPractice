package com.sankiid.tree;

public class RemoveNodeNotInRange {

	public static void main(String[] args) {
		Node<Integer> root = new Node<>(6);
		root.left = new Node<>(2);
		root.right = new Node<>(14);
		root.left.left = new Node<>(1);
		root.left.right = new Node<>(5);
		root.right.left = new Node<>(10);
		print(root);
		Node n = removeNodeOutofRange(root, 2, 12);
		System.out.println();
		print(n);
	}

	private static Node removeNodeOutofRange(Node<Integer> root, int min,
			int max) {
		if (root == null)
			return null;
		root.left = removeNodeOutofRange(root.left, min, max);
		root.right = removeNodeOutofRange(root.right, min, max);
		if (root.data < min)
			return root.right;
		if (root.data > max)
			return root.left;
		return root;
	}
	
	static void print(Node root){
		if(root == null) return;
		print(root.left);
		System.out.printf("%d ",root.data);
		print(root.right);
	}

}
