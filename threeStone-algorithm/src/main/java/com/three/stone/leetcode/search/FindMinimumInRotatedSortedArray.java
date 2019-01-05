package com.three.stone.leetcode.search;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Example 1:
 * Input: [3,4,5,1,2]
 * Output: 1
 * <p>
 * Example 2:
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */
public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            /**
             * 说明没有旋转
             */
            if (nums[low] < nums[high]) {
                return nums[low];
            }

            int mid = low + ((high - low) >> 1);
            if (nums[mid] >= nums[low]) {
                /**
                 * 左边
                 */
                low = mid + 1;
            } else {
                /**
                 * 右边，但mid可能是最小值，所以不能mid - 1
                 */
                high = mid;
            }
        }
        /**
         * 最后只有一个元素时
         */
        return nums[low];
    }

    public static void main(String[] args) {
        int[] A = new int[]{3, 4, 5, 1, 2};
        int[] B = new int[]{4, 5, 6, 7, 0, 1, 2};
        int[] C = new int[]{3, 0};
        System.out.println(findMin(A));
        System.out.println(findMin(B));
        System.out.println(findMin(C));
    }
}
