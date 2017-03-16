package com.sankiid.tree;

/**
 * Created by sankiid on 12-03-2017.
 */
public class InorderSuccessor {

    static class SuccessorNode {
        int data;
        SuccessorNode left;
        SuccessorNode right;
        SuccessorNode parent;

        public SuccessorNode(int data, SuccessorNode parent) {
            this.data = data;
            this.parent = parent;
        }
    }

    public static void main(String[] args) {
        SuccessorNode root = new SuccessorNode(6, null);
        root.left = new SuccessorNode(5, root);
        root.left.left = new SuccessorNode(3, root.left);
        root.left.left.right = new SuccessorNode(4, root.left.left);
        root.right = new SuccessorNode(8, root);
        root.right.left = new SuccessorNode(7, root.right);

        SuccessorNode s = findInorderSuccessor(root.left.left.right);
        System.out.print(s == null ? null : s.data);
    }

    private static SuccessorNode findInorderSuccessor(SuccessorNode node) {
        if (node == null) return null;
        if (node.right != null) {
            SuccessorNode tmp = node.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            return tmp;
        } else {
            SuccessorNode parent = node.parent;
            while (parent != null) {
                if (parent.left == node) {
                    return parent;
                }
                node = parent;
                parent = parent.parent;
            }
            return null;
        }
    }
}
