package medium.p3.longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;

public class Solution {


    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0, sLength = s.length();
        int[] lastIndex = new int[128];

        for (int end = 0, start = 0; end < sLength; end++) {
            char currentChar = s.charAt(end);
            start = Math.max(lastIndex[currentChar], start);
            maxLength = Math.max(maxLength, end - start + 1);
            lastIndex[currentChar] = end + 1;
        }

        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        int resultCount = 0;
        char[] chars = s.toCharArray();
        int from = 0, to;

        int len = s.length();

        HashSet<Character> cache = new HashSet<>();

        for (to = 0; to < len; to++) {
            char one = chars[to];

            if (cache.contains(one)) {
                resultCount = Math.max(resultCount, to - from);

                while (true) {
                    char prevOne = chars[from++];
                    if (prevOne == one) break;
                    cache.remove(prevOne);
                }
            } else {
                cache.add(one);
            }
        }

        return Math.max(resultCount, to - from);
    }
}
