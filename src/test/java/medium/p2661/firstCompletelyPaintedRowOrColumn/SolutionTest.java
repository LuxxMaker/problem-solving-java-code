package medium.p2661.firstCompletelyPaintedRowOrColumn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void firstCompleteIndex() {
        Solution solution = new Solution();

        int[] arr = new int[]{1, 3, 4, 2};
        int[][] mat = new int[][]{{1, 4}, {2, 3}};
        assertEquals(2, solution.firstCompleteIndex(arr, mat));


        int[] arr2 = new int[]{1, 4, 5, 2, 6, 3};
        int[][] mat2 = new int[][]{{4, 3, 5}, {1, 2, 6}};
        assertEquals(1, solution.firstCompleteIndex(arr2, mat2));
    }
}