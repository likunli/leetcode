
import java.util.*;

class Solution {

    static void setZeroes(int[][] input) {
        if (input.length == 0 || input[0].length == 0) {
            return;
        }
        boolean resetRowZero = false;
        boolean resetColZero = false;
        for (int i = 0; i < input.length; i++) {
            if (input[i][0] == 0) {
                resetColZero = true;
            }
        }

        for (int j = 0; j < input[0].length; j++) {
            if (input[0][j] == 0) {
                resetRowZero = true;
            }
        }

        for (int i = 1; i < input.length; i++) {
            for (int j = 1; j < input[0].length; j++) {
                if (input[i][j] == 0) {
                    input[i][0] = 0;
                    input[0][j] = 0;
                }
            }
        }

        
        for (int i = 1; i < input.length; i++) {
            if (input[i][0] == 0) {
                for (int j = 1; j < input[0].length; j++) {
                    input[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < input[0].length; j++) {
            if (input[0][j] == 0) {
                for (int i = 1; i < input.length; i++) {
                    input[i][j] = 0;
                }
            }
        }

        if (resetRowZero) {
            for (int j = 0; j < input[0].length; j++) {
                input[0][j] = 0;
            }
        }

        if (resetColZero) {
            for (int i = 0; i < input.length; i++) {
                input[i][0] = 0;
            }
        }
    }

    // Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
    // Example 1:

    // Input: 
    // [
    // [1,1,1],
    // [1,0,1],
    // [1,1,1]
    // ]
    // Output: 
    // [
    // [1,0,1],
    // [0,0,0],
    // [1,0,1]
    // ]

    // 0 1 2 0
    // 3 4 5 2
    // 1 3 1 5
    public static void main(String[] args) {
        int[][] input = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1},
        };
        setZeroes(input);
        for (int i = 0; i < input.length; i++) {
            System.out.println(Arrays.toString(input[i]));
        }
    }
}