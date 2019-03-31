import java.util.*;


class Solution {

    // dp question
    static boolean wordBreak(String s, List<String> wordList) {
        if (wordList == null || s == null) {
            return false;
        }

        // dp[i] means if string (0 ... i) could formed by wordList
        boolean[] dp = new boolean[s.length()];

        // [j, i]   (j - 1, i + 1)
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || dp[j - 1]) {
                    String sub = s.substring(j, i + 1);
                    if (wordList.contains(sub)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }

    // Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
    //  determine if s can be segmented into a space-separated sequence of one or more dictionary words.
    
    // Note:
    // The same word in the dictionary may be reused multiple times in the segmentation.
    // You may assume the dictionary does not contain duplicate words.
    // Example 1:

    // Input: s = "leetcode", wordDict = ["leet", "code"]
    // Output: true
    // Explanation: Return true because "leetcode" can be segmented as "leet code".

    // Input: s = "applepenapple", wordDict = ["apple", "pen"]
    // Output: true
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>(Arrays.asList("apple", "pen"));
        String s = "applepenapple";

        boolean judge = wordBreak(s, wordList);
        System.out.println(judge);
    }
}