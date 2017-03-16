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
        root.left.right = new Node<>(1);
        root.right.left = new Node<>(4);
        boolean bool = isHeightBalanced(root);
        System.out.println(bool);
        printKDistanceNode(root, 2);
    }

    private static void printKDistanceNode(Node<Integer> root, int k) {
        if (root == null) return;
        if (k < 0) return;
        if (k == 0)
            System.out.print(root.data + " ");
        printKDistanceNode(root.left, k - 1);
        printKDistanceNode(root.right, k - 1);
    }

    private static boolean isHeightBalanced(Node<Integer> root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.abs(left - right) <= 1 && isHeightBalanced(root.left) && isHeightBalanced(root.right);

    }

    private static int getHeight(Node<Integer> root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
