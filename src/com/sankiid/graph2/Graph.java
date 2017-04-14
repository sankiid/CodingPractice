package com.sankiid.graph2;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by sankiid on 06-03-2017.
 */
public class Graph {

    private LinkedList<Integer>[] adjList = null;
    private boolean directed = false;

    public Graph(int verticesCount, boolean directed) {
        this.directed = directed;
        this.adjList = new LinkedList[verticesCount];
        for (int i = 0; i < verticesCount; ++i) {
            this.adjList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int v1, int v2) {
        adjList[v1].add(v2);
        if (!directed) {
            adjList[v2].add(v1);
        }
    }

    public LinkedList<Integer> getChilds(Integer vertex){
        return adjList[vertex];
    }

    public int size() {
        return adjList.length;
    }

    public void bfs() {
        boolean[] visited = new boolean[size()];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < size(); ++i) {
            if (visited[i]) continue;
            queue.add(i);
            visited[i] = true;
            while (!queue.isEmpty()) {
                Integer v = queue.poll();
                System.out.printf("%d ", v);
                Iterator<Integer> itr = adjList[v].iterator();
                while (itr.hasNext()) {
                    Integer w = itr.next();
                    if (!visited[w]) {
                        queue.add(w);
                        visited[w] = true;
                    }
                }
            }
        }
        System.out.println();
    }

    public void dfs() {
        boolean[] visited = new boolean[size()];
        for (int i = 0; i < size(); ++i)
            dfs(i, visited);
        System.out.println();
    }

    private void dfs(int v, boolean[] visited) {
        if (visited[v])
            return;
        System.out.printf("%d ", v);
        visited[v] = true;
        Iterator<Integer> itr = adjList[v].iterator();
        while (itr.hasNext()) {
            Integer w = itr.next();
            if (!visited[w]) {
                dfs(w, visited);
            }
        }
    }

    public void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[size()];
        for (int i = 0; i < size(); ++i) {
            if (!visited[i])
                dfs(i, visited, stack);
        }
        while (!stack.isEmpty()) {
            System.out.printf("%d ", stack.pop());
        }
    }

    private void dfs(int v, boolean[] visited, Stack<Integer> stack) {
        if (visited[v]) return;
        visited[v] = true;
        Iterator<Integer> itr = adjList[v].iterator();
        while (itr.hasNext()) {
            Integer w = itr.next();
            if (!visited[w]) {
                dfs(w, visited, stack);
            }
        }
        stack.push(v);
    }
}
