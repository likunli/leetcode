
import java.util.*;

class Solution {

    static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    // You are climbing a stair case. It takes n steps to reach to the top.
    // Each time you can either climb 1 or 2 steps. 
    // In how many distinct ways can you climb to the top?
    // Note: Given n will be a positive integer.
    // Example 1:
    
    // Input: 2
    // Output: 2
    // Explanation: There are two ways to climb to the top.
    // 1. 1 step + 1 step
    // 2. 2 steps
    public static void main(String[] args) {
        int input = 2;
        int result = climbStairs(input);
        System.out.println(result);
    }
}