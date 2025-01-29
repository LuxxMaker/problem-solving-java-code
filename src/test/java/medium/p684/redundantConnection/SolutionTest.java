package medium.p684.redundantConnection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findRedundantConnection() {
        Solution solution = new Solution();
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};

        assertArrayEquals(new int[]{2,3}, solution.findRedundantConnection(edges));

        int[][] edges2 = {{3, 4}, {1, 2}, {2, 4}, {3, 5}, {2, 5}};
        assertArrayEquals(new int[]{2,5}, solution.findRedundantConnection(edges2));
    }
}