
import java.util.*;

class Solution {

    static List<Integer> spiralOrder(int[][] input)  {
        List<Integer> res = new ArrayList<>();
        if (input.length == 0 || input[0].length == 0) {
            return res;
        }
        int curX = 0;
        int curY = 0;

        int left = 0;
        int top = 0;
        int right = input[0].length - 1;
        int bottom = input.length - 1;
        int count = 0;
        // (curX, curY)
        while (count < input.length * input[0].length) {
            // move right
            while (curY <= right && count < input.length * input[0].length) {
                res.add(input[curX][curY]);
                count++;
                curY++;
            }
            top++;
            curY--;
            curX++;

            // move bottom
            while (curX <= bottom && count < input.length * input[0].length) {
                res.add(input[curX][curY]);
                curX++;
                count++;
            }
            right--;
            curX--;
            curY--;

            // move left
            while (curY >= left && count < input.length * input[0].length) {
                res.add(input[curX][curY]);
                curY--;
                count++;
            }
            bottom--;
            curX--;
            curY++;

            // move top
            while (curX >= top && count < input.length * input[0].length) {
                res.add(input[curX][curY]);
                curX--;
                count++;
            }
            left++;
            curX++;
            curY++;
        }

        return res;
    }

    // Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

    // Example 1:
    // Input:
    // [
    // [ 1, 2, 3 ],
    // [ 4, 5, 6 ],
    // [ 7, 8, 9 ]
    // ]
    // Output: [1,2,3,6,9,8,7,4,5]
    //
    //  1  2  3  4
    //  5  6  7  8
    //  9 10 11 12
    public static void main(String[] args) {
        int[][] input = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> result = spiralOrder(input);
        System.out.println(result);
    }
}