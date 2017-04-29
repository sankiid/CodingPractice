package com.sankiid.tree;

/**
 * Created by sankiid on 12-03-2017.
 */
public class RightNeighbour {

    static class RightNeighbourNode {
        int data;
        RightNeighbourNode left;
        RightNeighbourNode right;
        RightNeighbourNode neighbour;

        public RightNeighbourNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        RightNeighbourNode node = new RightNeighbourNode(0);
        node.left = new RightNeighbourNode(1);
        node.right = new RightNeighbourNode(2);
        node.left.left = new RightNeighbourNode(3);
        node.right.left = new RightNeighbourNode(5);
        node.right.right = new RightNeighbourNode(6);
        node.right.right.left = new RightNeighbourNode(7);
        node.right.right.right = new RightNeighbourNode(8);

        populateRightNeighbour(node);
        System.out.println();
    }

    private static void populateRightNeighbour(RightNeighbourNode node) {
        if (node == null) return;
        if (node.left != null) {
            if (node.right != null) {
                node.left.neighbour = node.right;
            } else {
                RightNeighbourNode tmp = node.neighbour;
                while (tmp != null) {
                    if (tmp.left != null) {
                        node.left.neighbour = tmp.left;
                        break;
                    } else if (tmp.right != null) {
                        node.left.neighbour = tmp.right;
                        break;
                    }
                    tmp = tmp.neighbour;
                }
            }
        }
        if (node.right != null) {
            RightNeighbourNode tmp = node.neighbour;
            while (tmp != null) {
                if (tmp.left != null) {
                    node.right.neighbour = tmp.left;
                    break;
                } else if (tmp.right != null) {
                    node.right.neighbour = tmp.right;
                    break;
                }
                tmp = tmp.neighbour;
            }
        }
        populateRightNeighbour(node.left);

        populateRightNeighbour(node.right);
    }
}
