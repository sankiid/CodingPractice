package com.sankiid.graph;

import java.util.*;

/**
 * Created by sandeep on 19/2/17.
 */
public class Graph {

    private Map<Vertex, List<Edge>> adjacencyList;
    private boolean directed = false;

    public Graph(boolean isDirected) {
        this.directed = isDirected;
        adjacencyList = new HashMap<Vertex, List<Edge>>();
    }

    public void add(Vertex v1, Vertex v2, int weight) {
        addUtil(v1, v2, weight);
        if (!directed) {
            addUtil(v2, v1, weight);
        }
    }

    private void addUtil(Vertex v1, Vertex v2, int weight) {
        List<Edge> edges = adjacencyList.get(v1);
        if (edges == null || edges.isEmpty()) {
            edges = new LinkedList<Edge>();
        }
        if (v2 != null) {
            v2.setInDegree(v2.getInDegree() + 1);
            Edge e = new Edge(v1, v2, weight);
            edges.add(e);
        }
        v1.setOutDegree(v1.getOutDegree() + 1);
        adjacencyList.put(v1, edges);
    }

    public void print() {
        if (adjacencyList != null && !adjacencyList.isEmpty()) {
            System.out.println();
            for (Map.Entry<Vertex, List<Edge>> entry : adjacencyList.entrySet()) {
                System.out.print(entry.getKey() + " ===> [");
                List<Edge> edges = entry.getValue();
                if (edges != null && !edges.isEmpty()) {
                    for (Edge e : edges) {
                        System.out.print("{" + e.getEndVertex() + ":" + e.getWeight() + "} -> ");
                    }
                }
                System.out.print("]\n");
            }
        }
    }

    public void addEdge(Edge edge) {
        add(edge.getStartVertex(), edge.getEndVertex(), edge.getWeight());
    }

    public void dfs(Vertex v) {
        System.out.print("---------dfs traversal-----------------\n");
        dfsUtil(v, new HashSet<Vertex>());
    }

    private void dfsUtil(Vertex v, Set<Vertex> visited) {
        System.out.println(v);
        visited.add(v);
        List<Edge> edges = adjacencyList.get(v);
        if (edges != null && !edges.isEmpty()) {
            for (Edge e : edges) {
                if (!visited.contains(e.getEndVertex())) {
                    dfsUtil(e.getEndVertex(), visited);
                }
            }
        }
    }

    public void bfs(Vertex v) {
        System.out.print("---------bfs traversal-----------------\n");
        bfsUtil(v, new HashSet<Vertex>());
    }

    private void bfsUtil(Vertex v, HashSet<Vertex> visited) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(v);
        while (!queue.isEmpty()) {
            Vertex vw = queue.remove();
            if (visited.contains(vw)) {
                continue;
            }
            System.out.println(vw);
            visited.add(vw);
            List<Edge> edges = adjacencyList.get(vw);
            if (edges != null && !edges.isEmpty()) {
                for (Edge e : edges) {
                    if (!visited.contains(e.getEndVertex())) {
                        queue.add(e.getEndVertex());
                    }
                }
            }
        }
    }

    public void topologicalSort() {
        System.out.print("---------topological Sort-----------------\n");
        Stack<Vertex> stack = new Stack<>();
        for (Map.Entry<Vertex, List<Edge>> entry : adjacencyList.entrySet()) {
            if (entry.getKey().getInDegree() == 0) {
                stack.push(entry.getKey());
            }
        }
        while (!stack.isEmpty()) {
            Vertex v = stack.pop();
            System.out.println(v);
            List<Edge> edges = adjacencyList.get(v);
            if (edges != null && !edges.isEmpty()) {
                v.setOutDegree(v.getOutDegree() - edges.size());
                for (Edge e : edges) {
                    e.getEndVertex().setInDegree(e.getEndVertex().getInDegree() - 1);
                    if (e.getEndVertex().getInDegree() == 0) {
                        stack.push(e.getEndVertex());
                    }
                }
            }
        }
    }
}
