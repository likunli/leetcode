
import java.util.*;


class Solution {

    static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int origin = x;
        int reverse = 0;
        while (origin > 0) {
            reverse *= 10;
            reverse += origin % 10;
            origin /= 10;
        }
        return reverse == x;
    }

    public static void main(String[] args) {
        int input = -121;
        boolean judge = isPalindrome(input);
        System.out.println(judge);
    }
}