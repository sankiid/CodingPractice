package com.graph;


import java.util.LinkedList;

/**
 * Created by sankiid on 21-03-2017.
 */
public class Node {

    private int vertex;
    private LinkedList<Edge> edges = new LinkedList<Edge>();

    public Node(int vertex) {
        this.vertex = vertex;
    }

    public LinkedList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(LinkedList<Edge> edges) {
        this.edges = edges;
    }

    public void addEdge(Edge edge) {
        this.edges.add(edge);
    }

    public int getVertex() {
        return vertex;
    }

    public void setVertex(int vertex) {
        this.vertex = vertex;
    }
}
