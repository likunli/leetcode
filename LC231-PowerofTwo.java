import java.util.*;

class Solution {

    // if the num is the power of two
    // only one bit is gonna to be '1'
    static boolean isPowerOfTwo(int n) {
        if (n < 0) {
            return false;
        }

        return (n & (n - 1)) == 0;
    }
    // Given an integer, write a function to determine if it is a power of two.

    // Example 1:
    
    // Input: 1
    // Output: true 
    // Explanation: 20 = 1
    // Example 2:
    
    // Input: 16
    // Output: true
    // Explanation: 24 = 16

    public static void main(String[] args) {
        int input = 16;
        System.out.println(isPowerOfTwo(input));
    }
}