package com.sankiid.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sandeep on 17/2/17.
 */
public class LCA {
	public static void main(String[] args) {
		Node<Integer> root = new Node<>(6);
		root.left = new Node<>(3);
		root.right = new Node<>(8);
		root.left.left = new Node<>(1);
		root.left.right = new Node<>(5);
		root.right.left = new Node<>(7);
		root.right.right = new Node<>(10);
		System.out.println(findLcaViaPaths(root, 1, 10));
		System.out.println(findLcaViaPaths(root, 3, 5));

		Node<Integer> node = findLca(root, 3, 5);
		System.out.println(node);
		node = findLca(root, 100, 10);
		System.out.println(node);
	}

	private static Node<Integer> findLca(Node<Integer> root, int n1, int n2) {
		boolean[] ava = new boolean[2];
		checkNodesAvailable(root, n1, n2, ava);
		if (ava[0] && ava[1]) {
			return findLcaRec(root, n1, n2);
		}
		return null;
	}

	private static void checkNodesAvailable(Node<Integer> root, int n1, int n2, boolean[] ava) {
		if (root == null)
			return;
		if (root.data == n1) {
			ava[0] = true;
		} else if (root.data == n2) {
			ava[1] = true;
		}
		checkNodesAvailable(root.left, n1, n2, ava);
		checkNodesAvailable(root.right, n1, n2, ava);
	}

	private static Node<Integer> findLcaRec(Node<Integer> root, int n1, int n2) {
		if (root == null)
			return null;

		if (root.data == n1 || root.data == n2) {
			return root;
		}
		Node left = findLcaRec(root.left, n1, n2);
		Node right = findLcaRec(root.right, n1, n2);
		if (left != null && right != null) {
			return root;
		}
		return left != null ? left : right;
	}

	private static Integer findLcaViaPaths(Node<Integer> root, int n1, int n2) {
		List<Integer> paths = new LinkedList<>();
		List<List<Integer>> allPaths = new LinkedList<>();
		findAllPaths(root, paths, allPaths);
		List<Integer> path1 = findDataPath(allPaths, n1);
		List<Integer> path2 = findDataPath(allPaths, n2);
		if (path1 != null && path2 != null) {
			int size = path1.size() > path2.size() ? path2.size() : path1.size();
			for (int i = 0; i < size; ++i) {
				if (path1.get(i) == n1 || path2.get(i) == n2)
					return path1.get(i) == n1 ? n1 : n2;
				if (path1.get(i) == path2.get(i))
					continue;
				return path1.get(i - 1);
			}
		}
		return null;
	}

	private static List<Integer> findDataPath(List<List<Integer>> allPaths, int n) {
		for (List<Integer> paths : allPaths) {
			if (paths.contains(n)) {
				return paths;
			}
		}
		return null;
	}

	private static void findAllPaths(Node<Integer> root, List<Integer> paths, List<List<Integer>> allPaths) {
		if (root == null)
			return;
		paths.add(root.data);
		if (root.left == null && root.right == null) {
			List<Integer> list = new LinkedList<>();
			for (Integer path : paths) {
				list.add(path);
			}
			allPaths.add(list);
		}
		findAllPaths(root.left, paths, allPaths);
		findAllPaths(root.right, paths, allPaths);
		paths.remove(paths.size() - 1);
	}
}
