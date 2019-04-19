import java.util.*;
// Given a string which contains only lowercase letters, 
// remove duplicate letters so that every letter appear once and only once. 
// You must make sure your result is the smallest in lexicographical order among all possible results.

// Example 1:

// Input: "bcabc"
// Output: "abc"
// Example 2:

// Input: "cbacdcbc"
// Output: "acdb"

class Solution {

    static String removeDuplicateLetters(String s) {
        if (s.isEmpty()) {
            return "";
        } 
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        boolean[] visited = new boolean[26];
        Deque<Character> stack = new LinkedList<>();
  
        for (char c : s.toCharArray()) {
            count[c - 'a']--;

            if (visited[c - 'a']) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }

            stack.push(c);
            visited[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }

        return sb.toString();
    }


    // "cbacdcbc"
    // a c d b
    public static void main(String[] args) {
        String s = "bcabc";
        String result = removeDuplicateLetters(s);
        System.out.println(result);
    }
}