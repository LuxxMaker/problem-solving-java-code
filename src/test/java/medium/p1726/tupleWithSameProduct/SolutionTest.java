package medium.p1726.tupleWithSameProduct;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void tupleSameProduct() {
        Solution solution = new Solution();
        assertEquals(8, solution.tupleSameProduct(new int[]{2, 3, 4, 6}));
        assertEquals(40, solution.tupleSameProduct(new int[]{2, 3, 4, 6, 8, 12}));
    }

    @Test
    void tupleSameProduct2() {
        Solution solution = new Solution();
        assertEquals(8, solution.tupleSameProduct2(new int[]{2, 3, 4, 6}));
        assertEquals(40, solution.tupleSameProduct2(new int[]{2, 3, 4, 6, 8, 12}));
    }
}