package medium.p916.wordsubsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        final char A = 'a';

        int[] word2Count = new int[26];
        for (String word2 : words2) {
            int[] localCount = new int[26];
            for (char w : word2.toCharArray()) {
                localCount[w - A]++;
            }

            for (int i = 0; i < 26; i++) {
                word2Count[i] = Math.max(word2Count[i], localCount[i]);
            }
        }

        for (String word1 : words1) {
            int[] word1Count = new int[26];
            for (char w : word1.toCharArray()) {
                word1Count[w - A]++;
            }

            boolean isUniversal = true;
            for (int i = 0; i < 26; i++) {
                if (word1Count[i] < word2Count[i]) {
                    isUniversal = false;
                    break;
                }
            }

            if (isUniversal) {
                result.add(word1);
            }
        }
        return result;
    }
}
