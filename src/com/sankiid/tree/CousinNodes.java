package com.sankiid.tree;

public class CousinNodes {

	public static void main(String[] args) {
		Node<Integer> root = new Node<>(6);
		root.left = new Node<>(2);
		root.right = new Node<>(4);
		root.left.left = new Node<>(1);
		root.left.right = new Node<>(5);
		root.right.left = new Node<>(10);
		System.out.println(isCousin(root,1,10));
	}

	private static boolean isCousin(Node<Integer> root, int n1, int n2) {
		Object [] obj = new Object[6];
		findNodes(root,n1,n2,obj, 0);
		if(obj[0] != null && obj[3] != null){
			return (int)obj[2] == (int)obj[5] && ((Node)obj[1]).data != ((Node)obj[4]).data;
		}
		return false;
	}

	private static void findNodes(Node<Integer> root, int n1, int n2,
			Object[] obj, int level) {
		if(root == null) return;
		if((root.left != null && root.left.data == n1)|| (root.right != null && root.right.data == n1)){
			obj[0] = root.left != null && root.left.data == n1 ? root.left : root.right;
			obj[1] = root;
			obj[2] = level;
		}else if((root.left != null && root.left.data == n2) || (root.right != null && root.right.data == n2)){
			obj[3] = root.left != null && root.left.data == n2 ? root.left : root.right;
			obj[4] = root;
			obj[5] = level;
		}
		findNodes(root.left, n1, n2, obj, level+1);
		findNodes(root.right, n1, n2, obj, level+1);
	}

}
