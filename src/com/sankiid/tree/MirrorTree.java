package com.sankiid.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sandeep on 16/2/17.
 */

public class MirrorTree {
    static class IntegerWrapper {
        int count = 0;
    }

    static class NRayNode {
        Integer data;
        List<NRayNode> childs;

        public NRayNode(Integer data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node<Integer> root1 = new Node<>(6);
        root1.left = new Node<>(3);
        root1.right = new Node<>(8);
        root1.left.left = new Node<>(1);
        root1.left.right = new Node<>(5);
        root1.right.left = new Node<>(7);

        Node<Integer> root = getMirrorTree(root1);
        System.out.println();
        convertMirrorTree(root1);
        System.out.println();
        System.out.println(countLeaf(root, new IntegerWrapper()));
        System.out.println(getLeafCount(root));

        NRayNode n1 = new NRayNode(2);
        n1.childs = new LinkedList<>();
        n1.childs.add(new NRayNode(5));
        n1.childs.add(new NRayNode(6));

        NRayNode n2 = new NRayNode(3);
        n2.childs = new LinkedList<>();
        n2.childs.add(new NRayNode(7));

        NRayNode n3 = new NRayNode(4);
        n3.childs = new LinkedList<>();
        n3.childs.add(new NRayNode(8));
        n3.childs.add(new NRayNode(9));

        NRayNode node = new NRayNode(1);
        node.childs = new LinkedList<>();
        node.childs.add(n1);
        node.childs.add(n2);
        node.childs.add(n3);

        convertTOMirror(node);
        System.out.println();
    }

    private static void convertTOMirror(NRayNode node) {
        if(node == null) return;
        if(node.childs == null) return;
        for(NRayNode n : node.childs){
            convertTOMirror(n);
        }
        Collections.reverse(node.childs);
    }

    private static int countLeaf(Node<Integer> root, IntegerWrapper integer) {
        if (root == null)
            return 0;
        countLeaf(root.left, integer);
        countLeaf(root.right, integer);
        if (root.left == null && root.right == null) {
            integer.count++;
        }
        return integer.count;
    }

    private static int getLeafCount(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        else
            return getLeafCount(root.left) + getLeafCount(root.right);
    }

    private static Node<Integer> getMirrorTree(Node<Integer> root1) {
        if (root1 == null)
            return null;
        Node<Integer> root = new Node<Integer>(root1.data);
        Node<Integer> left = getMirrorTree(root1.left);
        Node<Integer> right = getMirrorTree(root1.right);
        root.left = right;
        root.right = left;
        return root;
    }

    private static void convertMirrorTree(Node<Integer> root) {
        if (root == null) return;
        convertMirrorTree(root.left);
        convertMirrorTree(root.right);
        Node<Integer> tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
