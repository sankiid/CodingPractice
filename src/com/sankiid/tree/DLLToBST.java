package com.sankiid.tree;

/**
 * Created by sankiid on 12-03-2017.
 */
public class DLLToBST {
    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1, null, null);
        head.right = new Node(2, head, null);
        head.right.right = new Node<>(3, head.right, null);
        head.right.right.right = new Node<>(4, head.right.right, null);
        head.right.right.right.right = new Node<>(5, head.right.right.right, null);

        Node<Integer> root = convertTOTree(head);
        inorder(root);
    }

    private static Node<Integer> convertTOTree(Node<Integer> head) {
        if (head == null) return null;
        if (head.left == null && head.right == null) return head;
        Node<Integer> mid = getMid(head);
        Node<Integer> second = mid.right;
        if (mid.left != null) {
            mid.left.right = null;
        }
        if(mid.right != null){
            mid.right.left = null;
        }
        mid.left = convertTOTree(head);
        mid.right = convertTOTree(second);
        return mid;
    }

    private static Node getMid(Node<Integer> head) {
        if (head == null) return null;
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        while (fast != null && fast.right != null) {
            slow = slow.right;
            fast = fast.right.right;
        }
        return slow;
    }

    private static void inorder(Node<Integer> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.printf("%d ", root.data);
        inorder(root.right);
    }
}
