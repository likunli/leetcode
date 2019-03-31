import java.util.*;


class Solution {

    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return new String(sArray).equals(new String(tArray));
    }

    // Given two strings s and t , write a function to determine if t is an anagram of s.

    // Example 1:    
    // Input: s = "anagram", t = "nagaram"
    // Output: true

    // Example 2:    
    // Input: s = "rat", t = "car"
    // Output: false
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean judge = isAnagram(s, t);
        System.out.println(judge);
    }
}