package com.sankiid.tree;

/**
 * Created by sankiid on 13-03-2017.
 * <p>
 * Given parent array representation of a tree, construct the tree using this parent array.
 * In this parent array representation, a node would be constructed with values taken from indices of
 * this array. For element parent[i], a node would be constructed with value 'i'. And parent node for
 * this constructed node with value 'i' would be node with value parent[i]. If parent[i] is -1, then
 * we make the node with value 'i' as the root of the tree.
 */
public class BTFromParentArray {
    public static void main(String[] args) {
        int[] parent = {
                3, 5, 0, -1, 5, 3, 0
        };
        Node<Integer> root = constructBinaryTree(parent);
        Node<Integer> root2 = constructBinaryTree2(parent);
        root2.inorder();
    }

    private static Node<Integer> constructBinaryTree2(int[] parent) {
        Node<Integer>[] nodes = new Node[parent.length];
        for (int i = 0; i < parent.length; ++i) {
            nodes[i] = new Node(i);
        }
        int rootId = -1;
        for (int i = 0; i < parent.length; ++i) {
            if (parent[i] == -1) {
                rootId = i;
                continue;
            }
            int child = i;
            int papa = parent[i];
            if (nodes[papa].left == null) {
                nodes[papa].left = nodes[child];
            } else {
                nodes[papa].right = nodes[child];
            }
        }
        return nodes[rootId];
    }

    private static Node<Integer> constructBinaryTree(int[] parent) {
        if (parent == null) return null;
        Node<Integer>[] nodes = new Node[parent.length];
        int rootIndx = -1;
        for (int i = 0; i < parent.length; ++i) {
            if (parent[i] == -1) {
                rootIndx = i;
            }
            constructBinaryTree(nodes, parent, i);
        }
        return nodes[rootIndx];
    }

    private static void constructBinaryTree(Node<Integer>[] nodes, int[] parent, int i) {
        if (nodes[i] != null) {
            return;
        }
        if (parent[i] == -1) {
            nodes[i] = new Node<>(i);
            return;
        }
        if (nodes[parent[i]] == null) {
            constructBinaryTree(nodes, parent, parent[i]);
        }
        nodes[i] = new Node(i);
        if (nodes[parent[i]] != null) {
            if (nodes[parent[i]].left == null) {
                nodes[parent[i]].left = nodes[i];
            } else {
                nodes[parent[i]].right = nodes[i];
            }
        }
    }
}
