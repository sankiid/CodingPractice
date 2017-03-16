package com.sankiid.graph2;

import com.sankiid.dynamic.EditDistance;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sankiid on 14-03-2017.
 */
public class SourceWordToDestination {
    public static void main(String[] args) {
        String[] dict = {"BCCI", "AICC", "ICC", "CCI", "MCC", "MCA", "ACC"};
        String source = "AICC";
        String dest = "MCC";
        int cost = findSourceWordToDestinationWordCost(source, dest, dict);
        System.out.printf("%d", cost);
    }

    private static int findSourceWordToDestinationWordCost(String source, String dest, String[] dict) {
        Graph graph = new Graph(dict.length, true);
        for (int i = 0; i < dict.length; ++i) {
            for (int j = 0; j < dict.length; ++j) {
                if (EditDistance.findMinDistance(dict[i], dict[j]) == 1) {
                    graph.addEdge(i, j);
                }
            }
        }
        int sourceId = -1, destId = -1, k = 0;
        while (k < dict.length) {
            if (dict[k].equals(source)) {
                sourceId = k;
            }
            if (dict[k].equals(dest)) {
                destId = k;
            }
            k++;
        }
        boolean[] visited = new boolean[dict.length];
        return bfs(graph, visited, sourceId, destId);
    }

    private static int bfs(Graph graph, boolean[] visited, int vertex, int destId) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        visited[vertex] = true;
        int cost = 0;
        boolean destFound = false;
        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            if (v == destId) {
                destFound = true;
                break;
            }
            cost++;
            Iterator<Integer> itr = graph.getChilds(v).iterator();
            while (itr.hasNext()) {
                Integer w = itr.next();
                if (!visited[w]) {
                    visited[w] = true;
                    queue.add(w);
                }
            }
        }
        return destFound ? cost : -1;
    }

}
