import java.util.*;


class Solution {

    static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        Set<Character> st = new HashSet<>(); 
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            while (st.contains(ch)) {
                st.remove(s.charAt(start));
                start++;
            }
            st.add(ch);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    // Given a string, find the length of the longest substring without repeating characters.

    // Example 1:
    
    // Input: "abcabcbb"
    // Output: 3 
    // Explanation: The answer is "abc", with the length of 3. 
    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}