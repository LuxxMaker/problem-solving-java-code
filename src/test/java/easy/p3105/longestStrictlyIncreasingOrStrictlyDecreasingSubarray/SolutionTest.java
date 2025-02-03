package easy.p3105.longestStrictlyIncreasingOrStrictlyDecreasingSubarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void longestMonotonicSubarray() {
        Solution solution = new Solution();
        assertEquals(2, solution.longestMonotonicSubarray(new int[]{1, 4, 3, 3, 2}));
        assertEquals(3, solution.longestMonotonicSubarray(new int[]{1, 9, 7, 1}));
    }

    @Test
    void longestMonotonicSubarray2() {
        Solution solution = new Solution();
        assertEquals(2, solution.longestMonotonicSubarray2(new int[]{1, 4, 3, 3, 2}));
        assertEquals(3, solution.longestMonotonicSubarray2(new int[]{1, 9, 7, 1}));
    }
}