package com.three.stone.leetcode.search;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2,3], target = 0
 * Output: 4
 * <p>
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArray {
    public static  int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                /**
                 * 处于左半边
                 */
                if (target < nums[mid] && target >= nums[low]) {
                    high = mid - 1;
                } else {
                    low = low + 1;
                }
            } else {
                /**
                 * 处于右半边
                 */
                if (target > nums[mid] && target <= nums[high]) {
                    low = low + 1;
                } else {
                    high = high - 1;
                }
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        int[] A = new int[]{5, 1, 3};
        System.out.println(search(A, 5));
    }

}
