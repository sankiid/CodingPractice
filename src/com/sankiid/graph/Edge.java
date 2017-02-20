package com.sankiid.graph;

/**
 * Created by sandeep on 19/2/17.
 */
public class Edge {

    private Vertex startVertex;
    private Vertex endVertex;
    private int weight;

    public Edge(Vertex startVertex, Vertex endVertex, int weight) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weight = weight;
    }
}
