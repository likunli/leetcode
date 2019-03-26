import java.util.*;


class Solution {

    static int longestValidParentheses(String s) {
        
        // stack
        if (s.isEmpty()) {
            return 0;
        }

        Deque<Integer> stack = new LinkedList<>();
        int max = 0;
        int lastEnd = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    lastEnd = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(max, i - lastEnd);
                    } else {
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }

        return max;
    }

    // Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
    // Example 1:

    // Input: "(()"
    // Output: 2
    // Explanation: The longest valid parentheses substring is "()"

    // Input: ")()())"
    // Output: 4
    // Explanation: The longest valid parentheses substring is "()()"
    public static void main(String[] args) {
        String s = "(()";
        int result = longestValidParentheses(s);
        System.out.println(result);
    }
}