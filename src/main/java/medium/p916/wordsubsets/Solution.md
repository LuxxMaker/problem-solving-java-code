# 916. Word Subsets [[Link]](https://leetcode.com/problems/word-subsets/description/?source=submission-noac)

You are given two string arrays words1 and words2.

A string b is a subset of string a if every letter in b occurs in a including multiplicity.

For example, "wrr" is a subset of "warrior" but is not a subset of "world".
A string a from words1 is universal if for every string b in words2, b is a subset of a.

Return an array of all the universal strings in words1. You may return the answer in any order.

```
Example 1:
Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
Output: ["facebook","google","leetcode"]

Example 2:
Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
Output: ["apple","google","leetcode"]
```

```
Constraints:

1 <= words1.length, words2.length <= 10^4
1 <= words1[i].length, words2[i].length <= 10
words1[i] and words2[i] consist only of lowercase English letters.
All the strings of words1 are unique.
```

## Solution 

###  Brute-Force Approach and Its Inefficiency

- Iterate through each word in words1.
- For each word in words1, iterate through all words in words2 and compare.
- For each pair of words, check if the word from words2 is a subset of the word from words1.
- Time Complexity Analysis:
  - Maximum length of words1 and words2: 10,000 each
  - Word length: up to 10 characters
    ```
    words1.length (10^4) * words2.length (10^4) * word length (10) * word length (10) = 10^10 operations
    ```
- Performing 10 billion operations is highly inefficient and impractical within reasonable time constraints. 
 

### 2. Optimized Approach Using Frequency Counting and Preprocessing

1. Preprocessing the Maximum Character Frequencies in words2
    - Iterate through each word in words2 and calculate the frequency of each character.
    - Compare the calculated frequencies with existing values and update the maximum frequency for each character.

2. Filtering words1 by Comparing with Preprocessed Frequencies
    - Iterate through each word in words1 and calculate the frequency of each character.
    - Compare the calculated frequencies with the preprocessed requirements.
    - If the word meets all the frequency requirements, add it to the result list
    ```
    words1.length (10^4) * word length (10) = 10^5 operations
    ```