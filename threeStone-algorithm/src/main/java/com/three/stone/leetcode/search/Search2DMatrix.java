package com.three.stone.leetcode.search;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        int length = rowLength * columnLength;

        int low = 0, high = length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            int row = mid / columnLength;
            int column = mid % columnLength;

            int value = matrix[row][column];
            if (target == value) {
                return true;
            } else if (target > value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
