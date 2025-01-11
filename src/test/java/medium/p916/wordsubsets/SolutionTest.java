package medium.p916.wordsubsets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void wordSubsets() {
        Solution solution = new Solution();
        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] words2 = {"e", "o"};
        String[] expected = {"facebook", "google", "leetcode"};
        assertArrayEquals(expected, solution.wordSubsets(words1, words2).toArray(new String[0]));

        words1 = new String[]{"amazon", "apple", "facebook", "google", "leetcode"};
        words2 = new String[]{"l", "e"};
        expected = new String[]{"apple", "google", "leetcode"};
        assertArrayEquals(expected, solution.wordSubsets(words1, words2).toArray(new String[0]));

        words1 = new String[]{"amazon", "apple", "facebook", "google", "leetcode"};
        words2 = new String[]{"e", "oo"};
        expected = new String[]{"facebook", "google"};
        assertArrayEquals(expected, solution.wordSubsets(words1, words2).toArray(new String[0]));

        words1 = new String[]{"amazon", "apple", "facebook", "google", "leetcode"};
        words2 = new String[]{"lo", "eo"};
        expected = new String[]{"google", "leetcode"};
        assertArrayEquals(expected, solution.wordSubsets(words1, words2).toArray(new String[0]));

    }
}