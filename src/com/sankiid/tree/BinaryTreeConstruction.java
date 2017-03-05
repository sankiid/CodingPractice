package com.sankiid.tree;

/**
 * Created by sankiid on 05-03-2017.
 */
public class BinaryTreeConstruction {
    public static void main(String[] args) {
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        Node<Integer> root = constructTree(inorder, postorder);
        System.out.println();

        /*
        Construct the binary tree from its parent array representation
         */
        int[] arr = {3, 5, 0, -1, 5, 3, 0};
        Node<Integer> node = constructBTFromParentArray(arr);
        System.out.println();
    }

    private static Node<Integer> constructBTFromParentArray(int[] arr) {
        if (arr == null) return null;
        Node[] nodes = new Node[arr.length];
        int rootIndex = -2;
        for (int i = 0; i < arr.length; ++i) {
            if(arr[i] == -1){
                rootIndex = i;
            }
            fillNodes(arr, nodes, i);
        }
        return nodes[rootIndex];
    }

    private static void fillNodes(int[] parent, Node[] nodes, int index) {
        if (nodes[index] != null) return;
        if (parent[index] == -1) {
            Node root = new Node(index);
            nodes[index] = root;
            return;
        }
        if (nodes[parent[index]] == null) {
            fillNodes(parent, nodes, parent[index]);
        }
        nodes[index] = new Node(index);
        if (nodes[parent[index]] != null) {
            if (nodes[parent[index]].left == null) {
                nodes[parent[index]].left = nodes[index];
            } else {
                nodes[parent[index]].right = nodes[index];
            }
        }
    }

    private static Node<Integer> constructTree(int[] inorder, int[] postorder) {
        return constructTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private static Node<Integer> constructTree(int[] inorder, int inStart, int inEnd, int[] postorder, int ptStart, int ptEnd) {
        if (inEnd < inStart || ptEnd < ptStart) return null;
        Node<Integer> node = new Node(postorder[ptEnd]);
        int idx = findInorderIndex(inorder, inStart, inEnd, postorder[ptEnd]);
        int leftSize = idx - inStart;
        int rightSize = inEnd - idx;
        node.right = constructTree(inorder, idx + 1, inEnd, postorder, ptEnd - rightSize, ptEnd - 1);
        node.left = constructTree(inorder, inStart, idx - 1, postorder, ptEnd - rightSize - leftSize, ptEnd - rightSize - 1);
        return node;
    }

    private static int findInorderIndex(int[] inorder, int inStart, int inEnd, int value) {
        int id = inStart;
        while (id <= inEnd) {
            if (inorder[id] == value) {
                break;
            }
            id++;
        }
        return id;
    }
}
