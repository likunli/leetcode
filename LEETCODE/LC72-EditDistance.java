import java.util.*;

class Solution {


    static int minDistance(String word1, String word2) {
        
        // dp[i][j] -> means the minimum changes when s = s.substring[0, i]  t = substring[0, j] 
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        // f(i, j - 1) represents insert operation
        // f(i - 1, j) represents delete operation
        // f(i - 1, j - 1) represents replace operation

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }


    // Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

    // You have the following 3 operations permitted on a word:

    // Insert a character
    // Delete a character
    // Replace a character
    // Example 1:

    // Input: word1 = "horse", word2 = "ros"
    // Output: 3
    // Explanation: 
    // horse -> rorse (replace 'h' with 'r')
    // rorse -> rose (remove 'r')
    // rose -> ros (remove 'e')
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        int result = minDistance(word1, word2);
        System.out.println(result);
    }
}