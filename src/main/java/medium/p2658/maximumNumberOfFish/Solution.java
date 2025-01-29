package medium.p2658.maximumNumberOfFish;

import java.util.Arrays;

public class Solution {
    public static final int[][] DIRS = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{
                {4, 5, 5}, {0, 10, 0}
        };
        System.out.println(solution.findMaxFish(grid));
    }

    public int findMaxFish(int[][] grid) {
        int result = 0;

        int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(visited[i], 0);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result = Math.max(result, dfs(i, j, grid, visited));
            }
        }

        return result;
    }

    public int dfs(int row, int col, int[][] grid, int[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length
                || visited[row][col] == 1 || grid[row][col] == 0) {
            return 0;
        }

        visited[row][col] = 1;

        int temp = 0;
        for (int[] dir : DIRS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            temp += dfs(newRow, newCol, grid, visited);
        }

        return  grid[row][col] + temp;
    }
}
