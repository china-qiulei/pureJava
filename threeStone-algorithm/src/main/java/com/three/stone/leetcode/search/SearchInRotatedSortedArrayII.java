package com.three.stone.leetcode.search;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * Example 1:
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 *
 * Example 2:
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 *
 * Follow up:
 *
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 */
public class SearchInRotatedSortedArrayII {
    public static boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return true;
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


        return false;

    }

    public static void main(String[] args) {
        int[] A = new int[]{2, 5, 6, 0, 0, 1, 2};
        System.out.println(search(A, 0));
        System.out.println(search(A, 3));
    }
}
