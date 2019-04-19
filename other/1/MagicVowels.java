import java.util.*;

class Solution {

    static int longestSubsequence(String s) {
        // last index for each vowel appeared, 'a', 'e', 'i', 'o', 'u'
        int[] lastIndex = {-1, -1, -1, -1, -1};
        int[] dp = new int[s.length()];
        
        int index = 0;
        int maxLen = 0;
        while (s.charAt(index) != 'a') {
            index++;
        }

        lastIndex[0] = index;
        dp[index] = 1;

        for (int i = index + 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            int vowelNumber = checkVowel(ch);
            if (vowelNumber >= 0) {
                
                if (lastIndex[vowelNumber] >= 0) {
                    dp[i] = 1 + dp[vowelNumber];
                }
                lastIndex[vowelNumber] = i;

                if (ch != 'a' && lastIndex[vowelNumber - 1] >= 0) {
                    dp[i] = Math.max(dp[i], 1 + dp[lastIndex[vowelNumber - 1]]);
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }

    private static int checkVowel(char c) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < vowels.length; i++) {
            if (c == vowels[i]) {
                return i;
            }
        }
        return -1;
    }

    // aeeiou is magical
    // subsequence: aeeiou
    // aeaioua is not
    // subsequence: ae a iou a
    // find the longest magical subsequence in a string

    // aeeiou -> aeeiou -> 6
    // aeaioua -> ae - iou -> 5
    public static void main(String[] args) {
        String s = "aeaioua";
        int len = longestSubsequence(s);
        System.out.println(len);
    }
}