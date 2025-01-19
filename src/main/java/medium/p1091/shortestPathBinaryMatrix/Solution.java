package medium.p1091.shortestPathBinaryMatrix;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 1},
                {1, 0}
        };

        Solution solution = new Solution();
        System.out.println(solution.shortestPathBinaryMatrix(grid));
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int lastRow = grid.length - 1;
        int lastCol = grid[0].length - 1;

        if (grid[0][0] == 1 || grid[lastRow][lastCol] == 1) {
            return -1;
        }

        Deque<int[]> dq = new ArrayDeque<>();
        dq.push(new int[]{0, 0});

        int[][] cost = new int[grid.length][grid[0].length];
        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        cost[0][0] = 1;

        int[][] directions = new int[][]{
                {0, 1}, {0, -1}, {1, 0}, {-1, 0},
                {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };

        while (!dq.isEmpty()) {
            int[] currPos = dq.pollFirst();

            for (int[] dir : directions) {
                int newRow = currPos[0] + dir[0];
                int newCol = currPos[1] + dir[1];

                if (newRow < 0 || newRow > lastRow || newCol < 0 || newCol > lastCol || grid[newRow][newCol] == 1) {
                    continue;
                }

                int newCost = cost[currPos[0]][currPos[1]] + 1;
                if (newCost < cost[newRow][newCol]) {
                    cost[newRow][newCol] = newCost;
                    dq.addLast(new int[]{newRow, newCol});
                }
            }
        }
        return cost[lastRow][lastCol] == Integer.MAX_VALUE ? -1 : cost[lastRow][lastCol];
    }
}
