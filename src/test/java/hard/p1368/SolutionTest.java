package hard.p1368;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void minCost() {
        Solution solution = new Solution();
        int[][] grid = new int[][]{
                {1, 1, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3},
                {4, 4, 4, 4}
        };
        assertEquals(2, solution.minCost(grid));
    }
}