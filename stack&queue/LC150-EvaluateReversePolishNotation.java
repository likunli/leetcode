import java.util.*;

class Solution {

    static int evalRPN(String[] input) {
        if (input.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new LinkedList<>();
        for (String str : input) {
            int right = 0, left = 0;
            switch (str) {
                case "+":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left + right);
                    break;
                case "-":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left - right);
                    break;
                case "*":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left * right);
                    break;
                case "/":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left / right);
                    break;
                default:
                    stack.push(Integer.parseInt(str));
                    break;
            }
        }
        return stack.pop();
    }

    // Evaluate the value of an arithmetic expression in Reverse Polish Notation.
    // Valid operators are +, -, *, /. Each operand may be an integer or another
    // expression.
    // Note:
    // Division between two integers should truncate toward zero.
    // The given RPN expression is always valid. That means the expression would
    // always evaluate to a result and there won't be any divide by zero operation.

    // Example 1:
    // Input: ["2", "1", "+", "3", "*"]
    // Output: 9
    // Explanation: ((2 + 1) * 3) = 9

    // Example 2:
    // Input: ["4", "13", "5", "/", "+"]
    // Output: 6
    // Explanation: (4 + (13 / 5)) = 6
    public static void main(String[] args) {
        String[] input = {"2", "1", "+", "3", "*"};
        int result = evalRPN(input);
        System.out.println(result);
    }
}