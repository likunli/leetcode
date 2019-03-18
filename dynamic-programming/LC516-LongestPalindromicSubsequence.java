
import java.util.*;

class Solution {

    static int findPotentialLongestPalindorme(String s) {
        
        if (s.isEmpty()) {
            return 0;
        }

        // dp[i][j] means -> in string s, index from i -> j, the maximum expected palindorme string length
        int[][] dp = new int[s.length()][s.length()];


        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        for (int j = 0; j < s.length(); j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][s.length() - 1];
    }

    // Given a string s, find the longest palindromic subsequence's length in s. 
    // You may assume that the maximum length of s is 1000.

    // Example 1:
    // Input:

    // "bbbab"
    // Output:
    // 4
    // One possible longest palindromic subsequence is "bbbb".
    public static void main(String[] args) {
        String s = "bbbab";
        int result = findPotentialLongestPalindorme(s);
        System.out.println(result);
    }
}