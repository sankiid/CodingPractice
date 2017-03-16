package com.sankiid.tree;

/**
 * Created by sankiid on 12-03-2017.
 */
public class IsBST {
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(10);
        root.left = new Node<>(5);
        root.right = new Node<>(20);
        root.left.left = new Node<>(1);
        root.right.left = new Node<>(12);

        System.out.print(isBST(Integer.MIN_VALUE, root, Integer.MAX_VALUE));
    }

    private static boolean isBST(int min, Node<Integer> root, int max) {
        if (root == null) return true;
        if (root.data <= min || root.data >= max) {
            return false;
        }
        return isBST(min, root.left, root.data) && isBST(root.data, root.right, max);
    }
}
