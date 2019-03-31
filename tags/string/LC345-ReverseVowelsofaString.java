import java.util.*;

class Solution {

    static String reverseVowels(String s) {
        if (s.isEmpty()) {
            return "";
        }
        char[] strArray = s.toCharArray();
        
        int start = 0;
        int end = strArray.length - 1;
        while (start < end && end >= 0 && start <= strArray.length - 1) {
            while (start <= strArray.length - 1 && !isVowel(strArray[start])) {
                start++;
            }

            while (end >= 0 && !isVowel(strArray[end])) {
                end--;
            }

            if (start < end && start >= 0 && end <= strArray.length - 1) {
                swap(strArray, start++, end--);
            } else {
                break;
            }
        }
        return new String(strArray); 
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    private static void swap(char[] strArray, int left, int right) {
        char tmp = strArray[left];
        strArray[left] = strArray[right];
        strArray[right] = tmp;
    }

    // Write a function that takes a string as input and reverse only the vowels of a string.
    
    // Example 1:
    // Input: "hello"
    // Output: "holle"
    public static void main(String[] args) {
        String s = "hello";
        String res = reverseVowels(s);
        System.out.println(res);
    }
}