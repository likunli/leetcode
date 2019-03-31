import java.util.*;

class Solution {

    // DP Question
    static int maxProduct(int[] input) {
        if (input.length == 0) {
            return 0;
        }

        int res = input[0];
        int[] max = new int[input.length];
        int[] min = new int[input.length];

        max[0] = input[0];
        min[0] = input[0];

        for (int i = 1; i < input.length; i++) {
            if (input[i] >= 0) {
                max[i] = Math.max(input[i], max[i - 1] * input[i]);
                min[i] = Math.min(input[i], min[i - 1] * input[i]);
            } else {
                max[i] = Math.max(input[i], min[i - 1] * input[i]);
                min[i] = Math.min(input[i], max[i - 1] * input[i]);
            }
            res = Math.max(max[i], res);
        }
        return res;
    }

    // Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
    // Example 1:
    // Input: [2,3,-2,4]
    // Output: 6
    // Explanation: [2,3] has the largest product 6.
    public static void main(String[] args) {
        int[] input = {2,3,-2,4};
        int result = maxProduct(input);
        System.out.println(result);
    }
}