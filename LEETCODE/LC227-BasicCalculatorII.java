import java.util.*;


class Solution {

    // + - * / 
    //LC 227
    static int calculator1(String input) {
        // 0 ( + ) 1 + 2 * 3
        int sum = 0;
        int pre = 0;
        int cur = 0;
        char preSign = '+';

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == ' ') {
                continue;
            } else if (Character.isDigit(ch)) {
                cur = cur * 10 + ch - '0';
            } else {
                if (preSign == '+') {
                    sum += pre;
                    pre = cur;
                } else if (preSign == '-') {
                    sum += pre;
                    pre = -cur;
                } else if (preSign == '*') {
                    pre *= cur;
                } else if (preSign == '/') {
                    pre /= cur;
                }
                preSign = ch;
                cur = 0;
            }
            System.out.println(cur);
        }

        if (preSign == '+') {
            sum += pre + cur;
        } else if (preSign == '-') {
            sum += pre - cur;
        } else if (preSign == '*') {
            sum += pre * cur;
        } else if (preSign == '/') {
            sum += pre / cur;
        }
        return sum;
    }


    // + - * / ( )
    //LC 772
    static int calculator2(String input) {

        if (input.length() == 0) {
            return 0;
        }

        Deque<Integer> stack = new LinkedList<>();
        int sum = 0;
        int cur = 0;
        char preSign = '+';

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == ' ') {
                continue;
            } else if (Character.isDigit(ch)) {
                cur = cur * 10 + ch - '0';
            } else if (ch == '(') {
                int forwordIdx = findPair(input.substring(i));
                cur = calculator2(input.substring(i + 1, i + forwordIdx));
                i += forwordIdx;
            } else {
                if (preSign == '+') {
                    stack.push(cur);
                } else if (preSign == '-') {
                    stack.push(-cur);
                } else if (preSign == '*') {
                    stack.push(stack.pop() * cur);
                } else if (preSign == '/') {
                    stack.push(stack.pop() / cur);
                }
                preSign = ch;
                cur = 0;
            }
        }

        if (preSign == '+') {
            stack.push(cur);
        } else if (preSign == '-') {
            stack.push(-cur);
        } else if (preSign == '*') {
            stack.push(stack.pop() * cur);
        } else if (preSign == '/') {
            stack.push(stack.pop() / cur);
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    private static int findPair(String s) {
        int level = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                level++;
            } else if (ch == ')') {
                level--;
                if (level == 0) {
                    return i;
                }
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
        // + - * /
        String q1 = "42";
        int result1 = calculator1(q1);
        System.out.println(result1);

        // + - * / ( )
        String q2 = " 1 + (2 * 3) / 2 - 3";
        int result2 = calculator2(q2);
        System.out.println(result2);
    }
}