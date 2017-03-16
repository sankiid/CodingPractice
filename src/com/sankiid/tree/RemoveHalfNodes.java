package com.sankiid.tree;

/**
 * Created by sankiid on 12-03-2017.
 */
public class RemoveHalfNodes {
    public static void main(String[] args) {
        Node<Integer> node = new Node<>(0);
        node.left = new Node<>(1);
        node.right = new Node<>(2);
        node.left.left = new Node<>(3);
        node.left.right = new Node<>(4);
        node.left.left.right = new Node<>(6);
        node.left.left.right.right = new Node<>(8);

        node.right.left = new Node<>(5);
        node.right.left.right = new Node<>(7);

        removeHalfNodes(node);
        System.out.println();
    }

    private static Node<Integer> removeHalfNodes(Node<Integer> node) {
        if (node == null) return null;
        node.left = removeHalfNodes(node.left);
        node.right = removeHalfNodes(node.right);
        if(node.left == null && node.right != null) {
            return node.right;
        }else if(node.left != null && node.right == null){
            return node.left;
        }
        return node;
    }
}
