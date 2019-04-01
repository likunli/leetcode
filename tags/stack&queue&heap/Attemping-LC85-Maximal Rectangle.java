
import java.util.*;

class Solution {

    static int maximalRectangle(String[][] input) {
        return 0;
    }

    // Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

    // Example:
    // Input:
    // [
    // ["1","0","1","0","0"],
    // ["1","0","1","1","1"],
    // ["1","1","1","1","1"],
    // ["1","0","0","1","0"]
    // ]
    // Output: 6
    public static void main(String[] args) {

        String[][] input = {
            {"1","0","1","0","0"},
            {"1","0","1","1","1"},
            {"1","1","1","1","1"},
            {"1","0","0","1","0"}
        };

        int result = maximalRectangle(input);
        System.out.println(result);
    }
}