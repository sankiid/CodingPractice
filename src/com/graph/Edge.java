package com.graph;

/**
 * Created by sankiid on 21-03-2017.
 */
public class Edge {

    private int source;
    private int destinamtion;
    private int weight;

    public Edge(int source, int destinamtion, int weight) {
        this.source = source;
        this.destinamtion = destinamtion;
        this.weight = weight;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestinamtion() {
        return destinamtion;
    }

    public void setDestinamtion(int destinamtion) {
        this.destinamtion = destinamtion;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "src=" + source +
                ", dest=" + destinamtion +
                ", wt=" + weight +
                '}';
    }
}
