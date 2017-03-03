package com.sankiid.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeType {

	public static void main(String[] args) {
		Node<Integer> root = new Node<>(6);
		root.left = new Node<>(2);
		root.right = new Node<>(4);
		root.left.left = new Node<>(1);
		root.left.right = new Node<>(5);
		root.right.left = new Node<>(10);
		System.out.println(isFulltree(root));
		System.out.println(isCompletetree(root));
	}

	private static boolean isCompletetree(Node<Integer> root) {
		if(root == null) return true;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		boolean flag = false;
		while(!queue.isEmpty()){
			Node node = queue.remove();
			if(node.left != null && node.right != null){
				if(flag) return false;
				queue.add(node.left);
				queue.add(node.right);
			}else if(node.left == null && node.right != null){
				return false;
			}else if(node.left != null && node.right == null){
				if(flag) return false;
				queue.add(node.left);
				flag = true;
			}else{
				flag = true;
			}
		}
		return true;
	}

	private static boolean isFulltree(Node<Integer> root) {
		if (root == null)
			return true;
		if ((root.left == null && root.right != null)
				|| (root.left != null && root.right == null))
			return false;
		
		return isFulltree(root.left) && isFulltree(root.right);
	}

}
