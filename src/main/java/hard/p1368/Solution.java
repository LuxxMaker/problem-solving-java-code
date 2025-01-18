package hard.p1368;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 1, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3},
                {4, 4, 4, 4}
        };

        System.out.println(new Solution().minCost(grid));
    }

    public int minCost(int[][] grid) {
        int lastRow = grid.length - 1;
        int lastCol = grid[0].length - 1;

        record Pos(int row, int col) {
        }

        Pos[] dirs = {new Pos(0, 1), new Pos(0, -1), new Pos(1, 0), new Pos(-1, 0)};
        int[][] costs = new int[lastRow + 1][lastCol + 1];
        for (int[] row : costs) Arrays.fill(row, Integer.MAX_VALUE);
        costs[0][0] = 0;


        Deque<Pos> dq = new ArrayDeque<>();
        dq.addLast(new Pos(0, 0));

        while (!dq.isEmpty()) {
            Pos pos = dq.pollFirst();
            int currRow = pos.row;
            int currCol = pos.col;
            int currentDir = grid[pos.row][pos.col];

            for (int i = 0; i < 4; i++) {
                Pos dir = dirs[i];
                int newRow = currRow + dir.row;
                int newCol = currCol + dir.col;
                if (newRow < 0 || newRow > lastRow || newCol < 0 || newCol > lastCol) {
                    continue;
                }

                int posDir = i + 1;
                int newCost = costs[currRow][currCol] + (currentDir == posDir ? 0 : 1);

                if (newCost < costs[newRow][newCol]) {
                    costs[newRow][newCol] = newCost;
                    if (currentDir == posDir) {
                        dq.addFirst(new Pos(newRow, newCol));
                    } else {
                        dq.addLast(new Pos(newRow, newCol));
                    }
                }
            }

        }

        return costs[lastRow][lastCol];
    }
}
