package com.sankiid.linked.dll;

/**
 * Created by sandeep on 17/2/17.
 */
public class DllToBinaryTree {
    public static void main(String[] arsg) {
        Dll<Integer> dll = new Dll<>();
        dll.insert(20);
        dll.insert(18);
        dll.insert(16);
        dll.insert(15);
        dll.insert(10);
        dll.insert(12);
        dll.insert(11);

        Node root = convertTOBinaryTree(dll.head);
        System.out.println();
    }

    private static Node<Integer> convertTOBinaryTree(Node<Integer> head) {
        if(head == null) return null;
        Node<Integer> mid = getMiddle(head);
        if (mid.left != null) {
            mid.left.right = null;
        }
        mid.left = convertTOBinaryTree(head);
        mid.right = convertTOBinaryTree(mid.right);
        return mid;
    }

    private static Node<Integer> getMiddle(Node<Integer> head) {
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        while (fast != null && fast.right != null) {
            if (fast.right != null && fast.right.right != null)
                fast = fast.right.right;
            slow = slow.right;
        }
        return slow;
    }
}
