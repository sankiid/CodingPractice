package com.sankiid.graph2;

/**
 * Created by sankiid on 06-03-2017.
 */
public class GraphDriver {

    public static void main(String [] args){
        Graph graph = new Graph(7, true);
        graph.addEdge(0,1);
        graph.addEdge(0,4);
        graph.addEdge(3,2);
        graph.addEdge(1,3);
        graph.addEdge(4,3);
        graph.addEdge(5,6);
        graph.bfs();
        graph.dfs();
    }
}
