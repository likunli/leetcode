import java.util.*;


class Solution {

    static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int start = 0;
        int end = matrix.length - 1;
        while (start < end) {
            int mid = start - (start - end) / 2;
            if (target > matrix[mid][matrix[0].length - 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        int row = start;
        start = 0;
        end = matrix[row].length - 1;
        while (start < end) {
            //System.out.println(start + "====" + end);
            int mid = start - (start - end) / 2;
            if (target > matrix[row][mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return matrix[row][start] == target;
    }

    // Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    // Integers in each row are sorted from left to right.
    // The first integer of each row is greater than the last integer of the previous row.
    // Example 1:

    // Input:
    // matrix = [
    // [1,   3,  5,  7],
    // [10, 11, 16, 20],
    // [23, 30, 34, 50]
    // ]
    // target = 3
    // Output: true
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50},
        };
        int target = 3;
        boolean result = searchMatrix(matrix, target);
        System.out.println(result);
    }
}