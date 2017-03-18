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
        String dest = "MCA";
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
        Queue<Integer[]> queue = new LinkedList<Integer[]>();
        int level = 0;
        queue.add(new Integer[]{vertex, level});
        visited[vertex] = true;
        int cost = -1;
        while (!queue.isEmpty()) {
            Integer[] arr = queue.poll();
            Integer v = arr[0];
            if (v == destId) {
                cost = arr[1];
                break;
            }
            Iterator<Integer> itr = graph.getChilds(v).iterator();
            while (itr.hasNext()) {
                Integer w = itr.next();
                if (!visited[w]) {
                    visited[w] = true;
                    queue.add(new Integer[]{w, arr[1] + 1});
                }
            }
        }
        return cost;
    }

}
