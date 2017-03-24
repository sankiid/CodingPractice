package com.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sankiid on 21-03-2017.
 */
public class Graph {

    private boolean directed;
    private Node[] adjList;
    private int vertixCount;

    public Graph(boolean directed, int vertexCount) {
        this.directed = directed;
        this.vertixCount = vertexCount;
        this.adjList = new Node[vertexCount];
        for (int i = 0; i < vertexCount; ++i) {
            adjList[i] = new Node(i);
        }
    }

    public void addEdge(int v1, int v2, int weight) {
        Edge edge = new Edge(v1, v2, weight);
        this.adjList[v1].addEdge(edge);
        this.adjList[v1].setVertex(v1);
        if (!this.directed) {
            edge = new Edge(v2, v1, weight);
            this.adjList[v2].addEdge(edge);
            this.adjList[v2].setVertex(v2);
        }
    }

    public void printBfs() {
        boolean[] visited = new boolean[vertixCount];
        for (int i = 0; i < vertixCount; ++i) {
            if (visited[i]) continue;
            Queue<Node> queue = new LinkedList<>();
            queue.add(adjList[i]);
            visited[i] = true;
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                System.out.printf("%d ", node.getVertex());
                for (Edge edge : node.getEdges()) {
                    if (!visited[edge.getDestinamtion()]) {
                        visited[edge.getDestinamtion()] = true;
                        queue.add(adjList[edge.getDestinamtion()]);
                    }
                }
            }
        }
        System.out.println();
    }

    public void printDfs() {
        boolean[] visited = new boolean[vertixCount];
        for (int i = 0; i < vertixCount; ++i) {
            dfs(i, visited);
        }
        System.out.println();
    }

    private void dfs(int v, boolean[] visited) {
        if (visited[v]) return;
        System.out.printf("%d ", v);
        visited[v] = true;
        for (Edge edge : adjList[v].getEdges()) {
            int w = edge.getDestinamtion();
            if (!visited[w]) {
                dfs(w, visited);
            }
        }
    }
}
