import java.util.*;

class Solution {
    // in-place
    // "a" -> "a"
    // "a", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b" -> "a", "b", "1",
    // "1"
    static int compress(char[] input) {
        if (input.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < input.length; i++) {
            char current = input[i];
            int count = 1;
            // i increase to the last same index that value equals to current
            while (i + 1 < input.length && input[i] == input[i + 1]) {
                i++;
                count++;
            }
            input[index++] = current;
            if (count > 1) {
                // Integer.toString()  ->  123 -> "123"
                for (char c : Integer.toString(count).toCharArray()) {
                    input[index++] = c;
                }
            }
        }
        return index;
    }

    // Given an array of characters, compress it in-place.
    // The length after compression must always be smaller than or equal to the
    // original array.
    // Every element of the array should be a character (not int) of length 1.
    // After you are done modifying the input array in-place, return the new length
    // of the array.

    // Follow up:
    // Could you solve it using only O(1) extra space?

    // Example 1:
    // Input:
    // ["a","a","b","b","c","c","c"]
    // Output:
    // Return 6, and the first 6 characters of the input array should be:
    // ["a","2","b","2","c","3"]
    // Explanation:
    // "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by
    // "c3".
    public static void main(String[] args) {
        char[] input = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        int len = compress(input);
        for (int i = 0; i < len; i++) {
            System.out.print(input[i]);
        }
    }
}