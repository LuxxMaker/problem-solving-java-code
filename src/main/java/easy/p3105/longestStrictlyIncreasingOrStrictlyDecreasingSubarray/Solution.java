package easy.p3105.longestStrictlyIncreasingOrStrictlyDecreasingSubarray;

// https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/description/?envType=daily-question&envId=2025-02-03

public class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int result = 1;
        int tempIncrement = 1;
        int tempDecrement = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                tempIncrement++;
                result = Math.max(result, tempDecrement);
                tempDecrement = 1;
            } else if (nums[i - 1] > nums[i]) {
                result = Math.max(result, tempIncrement);
                tempIncrement = 1;
                tempDecrement++;
            } else {
                result = Math.max(result, Math.max(tempIncrement, tempDecrement));
                tempIncrement = 1;
                tempDecrement = 1;
            }
        }

        return Math.max(result, Math.max(tempIncrement, tempDecrement));
    }

    public int longestMonotonicSubarray2(int[] nums) {
        int result = 1;
        int tempIncrement = 1;
        int tempDecrement = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                tempIncrement++;
                tempDecrement = 1;
            } else if (nums[i - 1] > nums[i]) {
                tempIncrement = 0;
                tempDecrement++;
            } else {
                tempIncrement = 1;
                tempDecrement = 1;
            }

            result = Math.max(result, Math.max(tempIncrement, tempDecrement));
        }

        return result;
    }
}
