package medium.p1726.tupleWithSameProduct;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.tupleSameProduct2(new int[]{2, 3, 4, 6}));
        System.out.println(s.tupleSameProduct2(new int[]{2, 3, 4, 6, 8, 12}));
    }

    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = nums[i] * nums[j];
                map.merge(temp, 1, Integer::sum);
            }
        }

        int result = 0;
        var a = map.values();
        for (var value : a) {
            if (value < 2) continue;
            result += (value * (value - 1)) / 2;
        }
        return result * 8;
    }

    public int tupleSameProduct2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = nums[i] * nums[j];
                int count = map.getOrDefault(temp, 0);
                result += count * 8;
                map.put(temp, count + 1);
            }
        }
        return result;
    }
}