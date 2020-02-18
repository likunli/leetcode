import java.util.*;

class Solution {

    // expand from each point
    static int countSubstrings(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += expand(s, i, i) + expand(s, i, i + 1);
        }
        return sum;
    }

    private static int expand(String s, int left, int right) {

        int count = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            } else {
                break;
            }
        }
        return count;
    }

    // Given a string, your task is to count how many palindromic substrings in this string.
    // The substrings with different start indexes or end indexes are 
    // counted as different substrings even they consist of same characters.

    // Example 1:
    // Input: "abc"
    // Output: 3
    // Explanation: Three palindromic strings: "a", "b", "c".
    

    // Example 2:
    // Input: "aaa"
    // Output: 6
    // Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
    public static void main(String[] args) {
        String s = "abc";
        int result = countSubstrings(s);
        System.out.println(result);
    }
}