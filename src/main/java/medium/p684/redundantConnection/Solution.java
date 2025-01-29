package medium.p684.redundantConnection;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] edges = {{3, 4}, {1, 2}, {2, 4}, {3, 5}, {2, 5}};
        int[] result = solution.findRedundantConnection(edges);
        System.out.println(result[0] + " " + result[1]);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] parentArr = new int[edges.length+1];
        for(int i = 0; i < parentArr.length; i++) {
            parentArr[i] = i;
        }

        for(int[] edge : edges) {
            int rootU = this.findUnion(parentArr, edge[0]);
            int rootV = this.findUnion(parentArr, edge[1]);

            if(rootU == rootV) {
                return edge;
            }
            parentArr[rootU] = rootV;
        }
        return new int[]{0, 0};
    }

    public int findUnion(int[] cache, int u) {
        if(cache[u] == u) {
            return cache[u];
        } else {
            return cache[u] =  this.findUnion(cache, cache[u]);
        }
    }
}