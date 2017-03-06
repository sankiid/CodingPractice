package com.sankiid.graph2;

/**
 * Created by sankiid on 06-03-2017.
 *
 * 0 => [1,5]
 * 2 => [0,3]
 * 3 => [4]
 * 5 => [1,3,4]
 */
public class TopologicalSort {
    public static void main(String[] args) {
        Graph graph = new Graph(6, true);
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 0);
        graph.addEdge(3, 4);

        graph.addEdge(5, 1);
        graph.addEdge(5, 3);
        graph.addEdge(5, 4);
        graph.topologicalSort();
    }
}
