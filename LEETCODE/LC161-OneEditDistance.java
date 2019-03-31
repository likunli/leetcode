import java.util.AbstractCollection;


class Solution {

    // make s.length < t.length
    static boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }

        if (s.length() > t.length()) {
            return isOneEditDistance(t, s);
        }
        
        if (s.equals(t)) {
            return false;
        }

        int index = 0;

        while (index < s.length()) {
            if (s.charAt(index) != t.charAt(index)) {
                return s.substring(index + 1).equals(t.substring(index + 1))
                    || s.substring(index).equals(t.substring(index + 1));
            }
            index++;
        }
        return true;
    }
}

    // Given two strings s and t, determine if they are both one edit distance apart.

    // Note: 
    // There are 3 possiblities to satisify one edit distance apart:

    // Insert a character into s to get t
    // Delete a character from s to get t
    // Replace a character of s to get t
    // Example 1:

    // Input: s = "ab", t = "acb"
    // Output: true
    // Explanation: We can insert 'c' into s to get t.
    public static void main(String[] args) {
        String s = "ab";
        String t = "acb";
        boolean result = isOneEditDistance(s, t);
        System.out.println(result);
    }
}