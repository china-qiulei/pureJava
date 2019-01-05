package com.three.stone.leetcode.search;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * The array may contain duplicates.
 *
 * Example 1:
 *
 * Input: [1,3,5]
 * Output: 1
 *
 * Example 2:
 * Input: [2,2,2,0,1]
 * Output: 0
 */
public class FindMinimumInRotatedSortedArrayII {
    public static int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + ((high - low) >> 1);

            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                /**
                 * when num[mid] and num[hi] are same
                 */
                high--;
            }
        }

        return nums[low];
    }
}
