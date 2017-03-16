package com.sankiid.tree;

/**
 * Created by sankiid on 12-03-2017.
 */
public class BalancedBSTFromArray {
    public static void main(String[] args) {
        int array[] = {3, 6, 8, 23, 48, 76, 89};
        Node<Integer> root = createBst(array, 0, array.length - 1);
        inorder(root);
    }

    private static void inorder(Node<Integer> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    private static Node<Integer> createBst(int[] array, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        Node<Integer> left = createBst(array, start, mid - 1);
        Node<Integer> right = createBst(array, mid + 1, end);
        Node<Integer> root = new Node<>(array[mid]);
        root.left = left;
        root.right = right;
        return root;
    }
}
