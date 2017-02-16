package com.sankiid.tree;

/**
 * Created by sandeep on 16/2/17.
 */
public class SameTree {
    public static void main(String[] args) {
        Node<Integer> root1 = new Node<>(6);
        root1.left = new Node<>(3);
        root1.right = new Node<>(8);
        root1.left.left = new Node<>(1);
        root1.left.right = new Node<>(5);
        root1.right.left = new Node<>(7);

        Node<Integer> root2 = new Node<>(6);
        root2.left = new Node<>(3);
        root2.right = new Node<>(8);
        root2.left.left = new Node<>(1);
        root2.left.right = new Node<>(5);
        root2.right.left = new Node<>(7);
        System.out.println(isIdenticalTrees(root1, root2));

        System.out.println(getHeight(root1));

        delete(root1);

        System.out.println(getHeight(root1));
    }

    private static void delete(Node<Integer> root) {
        root = null;
        return;
//        if(root != null){
//            delete(root.left);
//            delete(root.right);
//            root.left = null;
//            root.right = null;
//        }
    }

    private static int getHeight(Node<Integer> root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = getHeight(root.left) + 1;
        int right = getHeight(root.right) + 1;
        return left > right ? left : right;
    }

    private static boolean isIdenticalTrees(Node<Integer> root1, Node<Integer> root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.data == root2.data) {
            return isIdenticalTrees(root1.left, root2.left) && isIdenticalTrees(root1.right, root2.right);
        }
        return false;
    }
}
