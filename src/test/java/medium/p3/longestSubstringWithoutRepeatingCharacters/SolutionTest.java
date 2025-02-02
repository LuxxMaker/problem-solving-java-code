package medium.p3.longestSubstringWithoutRepeatingCharacters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void lengthOfLongestSubstring() {
        Solution solution = new Solution();
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
        assertEquals(0, solution.lengthOfLongestSubstring(""));
        assertEquals(1, solution.lengthOfLongestSubstring(" "));
        assertEquals(2, solution.lengthOfLongestSubstring("au"));
        assertEquals(3, solution.lengthOfLongestSubstring("dvdf"));
    }

    @Test
    void lengthOfLongestSubstring2() {
        Solution solution = new Solution();
        assertEquals(3, solution.lengthOfLongestSubstring2("abcabcbb"));
        assertEquals(1, solution.lengthOfLongestSubstring2("bbbbb"));
        assertEquals(3, solution.lengthOfLongestSubstring2("pwwkew"));
        assertEquals(0, solution.lengthOfLongestSubstring2(""));
        assertEquals(1, solution.lengthOfLongestSubstring2(" "));
        assertEquals(2, solution.lengthOfLongestSubstring2("au"));
        assertEquals(3, solution.lengthOfLongestSubstring2("dvdf"));
    }
}