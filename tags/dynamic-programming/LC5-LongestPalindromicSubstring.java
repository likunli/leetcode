
import java.util.*;

class Solution {

    // q1, get the result string, two pointers solution
    static String longestPalindrome2(String s) {
        // iterate through the string s
        // start at every node, as a middle node  (one mid / two mid)
        // find the longest palindrome string

        if (s.isEmpty()) {
            return "";
        }

        int[] max = new int[2];
        // max[0] -> start index,  max[1] -> end index

        for (int i = 0; i < s.length(); i++) {
            extend(s, max, i, i);
            extend(s, max, i, i + 1);
        }
        return s.substring(max[0], max[1] + 1);
    }

    private static void extend(String s, int[] max, int start, int end) {
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            } else {
                break;
            }
        }
        start++;
        end--;
        if (end - start > max[1] - max[0]) {
            max[1] = end;
            max[0] = start;
        }
    }

    //q1, dp solution
    static String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }

        // dp[i][j] means  string(i .... j) is avaid palindorme
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = Integer.MIN_VALUE;
        int startIdx = 0;
        int endIdx = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i > max) {
                        startIdx = i;
                        endIdx = j;
                        max = j - i;
                    }
                } 
            }
        }
        return s.substring(startIdx, endIdx + 1);
    }

    

    

    // Given a string s, find the longest palindromic substring in s.
    // You may assume that the maximum length of s is 1000.

    // Example 1:

    // Input: "babad"
    // Output: "bab"
    // Note: "aba" is also a valid answer.
    public static void main(String[] args) {
        String s = "babdd";
        String res = longestPalindrome(s);
        System.out.println(res);
    }
}