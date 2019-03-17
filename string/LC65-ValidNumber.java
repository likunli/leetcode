import java.util.*;

class Solution {

    // without e
    static boolean isNumber(String input) {
        input = input.trim();
        
        boolean dotSeen = false;
        boolean numberSeen = false;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= '0' && ch <= '9') {
                // digit
                numberSeen = true;
            } else if (ch == '.') {
                // dot
                if (dotSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (ch == '+' || ch == '-') {
                // sign
                if (i != 0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numberSeen;
    }

    // leetcode 65, consider the e problem
    static boolean isNumber2(String input) {
        input = input.trim();

        boolean dotSeen = false;
        boolean numberSeen = false;
        boolean eSeen = false;
        boolean numberAfterE = true;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= '0' && ch <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if (ch == '.') {
                if (eSeen || dotSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (ch == 'e') {
                if (eSeen || !numberSeen) {
                    return false;
                } 
                numberAfterE = false;
                eSeen = true;
            } else if (ch == '+' || ch == '-') {
                if (i != 0 && input.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numberAfterE && numberSeen;
    }

    public static void main(String[] args) {

        // "0" => true
        // " 0.1 " => true
        // "abc" => false
        // "1 a" => false
        // "2e10" => true
        // " -90e3   " => true
        // " 1e" => false
        // "e3" => false
        // " 6e-1" => true
        // " 99e2.5 " => false
        // "53.5e93" => true
        // " --6 " => false
        // "-+3" => false
        // "95a54e53" => false
        String input = "-.8";
        boolean judge = isNumber(input);
        System.out.println(judge);
    }
}