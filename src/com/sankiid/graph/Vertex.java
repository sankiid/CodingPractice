package com.sankiid.graph;

import java.util.List;

/**
 * Created by sandeep on 19/2/17.
 */
public class Vertex {

    private String label;
    private int id;

    public Vertex(int id, String label) {
        this.label = label;
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + label + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        return id == vertex.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
