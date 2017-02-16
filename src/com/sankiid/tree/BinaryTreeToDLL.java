package com.sankiid.tree;

/**
 * Created by sandeep on 17/2/17.
 */
public class BinaryTreeToDLL {

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(6);
        root.left = new Node<>(12);
        root.right = new Node<>(4);
        root.left.left = new Node<>(10);
        root.left.right = new Node<>(11);
        root.right.left = new Node<>(49);
        Node<Integer> head = binaryTreeToDLL(root);
        print(head);
    }

    private static Node<Integer> binaryTreeToDLL(Node<Integer> root) {
        NodeWrapper wrapper = new NodeWrapper();
        binaryTreeToDLLUtils(root, wrapper);
        return wrapper.head;
    }

    private static void binaryTreeToDLLUtils(Node<Integer> root, NodeWrapper wrapper) {
        if (root == null) {
            return;
        }
        binaryTreeToDLLUtils(root.left, wrapper);

        if (wrapper.head == null) {
            wrapper.head = root;
        } else {
            root.left = wrapper.previous;
            wrapper.previous.right = root;
        }
        wrapper.previous = root;

        binaryTreeToDLLUtils(root.right, wrapper);
    }

    private static void print(Node<Integer> head) {
        System.out.print("<->");
        while (head != null) {
            System.out.printf(" %d <-> ", head.data);
            head = head.right;
        }
    }

    static class NodeWrapper {
        Node<Integer> previous = null;
        Node<Integer> head = null;
    }
}
