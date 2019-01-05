package com.three.stone.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            int remain = target - nums[i];
            if (map.containsKey(remain)) {
                result[0] = map.get(remain);
                result[1] = i;
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int [] arr=new int[]{2, 3, 7, 5};
        System.out.println(Arrays.toString(twoSum(arr, 9)));
    }
}
