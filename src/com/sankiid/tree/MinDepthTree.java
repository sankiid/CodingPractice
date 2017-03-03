package com.sankiid.tree;

public class MinDepthTree {

	public static void main(String[] args) {
		Node<Integer> root = new Node<>(6);
		root.left = new Node<>(2);
		root.right = new Node<>(4);
		root.left.left = new Node<>(1);
		root.left.right = new Node<>(5);
		root.right.left = new Node<>(10);
		int min = findMinDepth(root);
		System.out.println(min);
		int sum = leftLeaveSum(root);
		System.out.println(sum);
		int level = deepestOddLevel(root, 0);
		System.out.println(level);
	}

	private static int deepestOddLevel(Node<Integer> root, int level) {
		if(root == null) return 0;
		if((level & 1) != 0 && root.left == null && root.right == null){
			return level;
		}
		return Math.max(deepestOddLevel(root.left, level+1), deepestOddLevel(root.right, level+1));
	}

	private static int leftLeaveSum(Node<Integer> root) {
		if (root == null)
			return 0;
		if (root.left != null && root.left.left == null && root.left.right == null) {
			return root.left.data;
		}
		return leftLeaveSum(root.left) + leftLeaveSum(root.right);
	}

	private static int findMinDepth(Node<Integer> root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int left = root.left != null ? findMinDepth(root.left)
				: Integer.MAX_VALUE;
		int right = root.right != null ? findMinDepth(root.right)
				: Integer.MAX_VALUE;
		return 1 + Math.min(left, right);
	}
}
