package com.sankiid.graph;

/**
 * Created by sandeep on 23/2/17.
 */
public class DriverClass {

    public static void main(String[] args) {
        Graph graph = new Graph(true);
        Vertex v1 = new Vertex(1, "v1");
        Vertex v2 = new Vertex(2, "v2");
        Vertex v3 = new Vertex(3, "v3");
        Vertex v4 = new Vertex(4, "v4");
        Vertex v5 = new Vertex(5, "v5");
        Vertex testV = new Vertex(111, "test-verstex");

        graph.add(v1, v2, 10);
        graph.add(v1, v3, 5);
        graph.add(v3, v2, 2);
        graph.add(v2, v4, 7);
        graph.add(v4, v5, 3);
        graph.print();
        graph.add(testV, null, -1);
        graph.print();
        graph.addEdge(new Edge(testV,v5,10));
        graph.print();
        graph.dfs(v1);
        graph.bfs(v1);
    }
}
