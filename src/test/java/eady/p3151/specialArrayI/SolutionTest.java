package eady.p3151.specialArrayI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void isArraySpecial() {
        Solution solution = new Solution();
        assertTrue(solution.isArraySpecial(new int[]{1}));
        assertTrue(solution.isArraySpecial(new int[]{2,1,4}));
        assertFalse(solution.isArraySpecial(new int[]{4,3,1,6}));
    }
}