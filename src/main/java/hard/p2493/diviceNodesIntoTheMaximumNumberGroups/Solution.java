package hard.p2493.diviceNodesIntoTheMaximumNumberGroups;

import java.util.*;

public class Solution {
    public int magnificentSets(int n, int[][] edges) {
        var graph = buildGraph(n, edges);
        if (!checkBipartite(graph, n, 1)) {
            return -1;
        }

        int result = 0;
        int[] visited = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (visited[i] == 1) {
                continue;
            }
            HashSet<Integer> connectedNodes = getConnectedNodes(graph, i, visited);
            result += getMaxLevel(graph, connectedNodes);
        }

        return result;
    }

    private int getMaxLevel(List<Integer>[] graph, HashSet<Integer> connectedNodes) {
        int result = 0;
        for (var i : connectedNodes) {
            int[] visited = new int[graph.length];
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            visited[i] = 1;
            int level = 1;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    int node = queue.poll();
                    for (int neighbor : graph[node]) {
                        if (visited[neighbor] == 0) {
                            visited[neighbor] = 1;
                            queue.add(neighbor);
                        }
                    }
                }
                level++;
            }
            result = Math.max(result, level - 1);
        }
        return result;
    }


    private HashSet<Integer> getConnectedNodes(List<Integer>[] graph, int i, int[] visited) {
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(i);
        set.add(i);
        visited[i] = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (!set.contains(neighbor)) {
                    visited[neighbor] = 1;
                    set.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return set;
    }


    public List<Integer>[] buildGraph(int n, int[][] edges) {
        var graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        return graph;
    }

    public boolean checkBipartite(List<Integer>[] graph, int n, int minIndex) {
        int[] color = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(minIndex);
        color[minIndex] = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (color[neighbor] == 0) {
                    color[neighbor] = -color[node];
                    queue.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false;
                }
            }
        }

        return true;
    }
}
