package com.graph;

/**
 * Created by sankiid on 21-03-2017.
 */
public class GraphMain {
    public static void main(String[] args) {
        Graph g1 = new Graph(true, 7);
        g1.addEdge(0, 1, 1);
        g1.addEdge(0, 2, 4);
        g1.addEdge(0, 3, 10);
        g1.addEdge(1, 3, 1);
        g1.addEdge(2, 3, 1);
        g1.addEdge(3, 1, 4);

        g1.addEdge(4, 5, 1);
        g1.addEdge(5, 4, 3);
        g1.printBfs();
        g1.printDfs();
        System.out.println();

    }
}
