package com.sankiid.tree;

public class SerializeDeserialize {

	public static void main(String[] args) {
		Node<Integer> root = new Node<>(20);
		root.left = new Node<>(10);
		root.right = new Node<>(24);
		root.left.left = new Node<>(5);
		root.left.right = new Node<>(12);
		root.right.left = new Node<>(22);
		int[] serialize = serialize(root);
		Node node = deserialize(serialize, new int[] { serialize.length - 1 }, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println();
	}

	private static Node deserialize(int[] serialize, int[] index, int minValue, int maxValue) {
		if (serialize == null)
			return null;
		if (index == null || index[0] < 0)
			return null;
		int val = serialize[index[0]];
		if (val > minValue && val < maxValue) {
			Node<Integer> root = new Node<>(val);
			index[0] -= 1;
			root.right = deserialize(serialize, index, root.data, maxValue);
			root.left = deserialize(serialize, index, minValue, root.data);
			return root;
		}
		return null;
	}

	private static int[] serialize(Node<Integer> root) {
		int n = getNodeCounts(root);
		int[] ser = new int[n];
		serialize(root, ser, new int[] { 0 });
		return ser;
	}

	private static void serialize(Node<Integer> root, int[] ser, int[] index) {
		if (root == null)
			return;
		serialize(root.left, ser, index);
		serialize(root.right, ser, index);
		ser[index[0]] = root.data;
		index[0] += 1;
	}

	private static int getNodeCounts(Node<Integer> root) {
		if (root == null)
			return 0;
		return 1 + getNodeCounts(root.left) + getNodeCounts(root.right);
	}

}
