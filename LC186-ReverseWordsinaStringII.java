import java.util.*;

class Solution {

    static void reverseWords(char[] words) {
        if (words.length == 0) {
            return;
        }
        // reverse all characters first
        rangeSwap(words, 0, words.length - 1);
        int start = 0;
        for (int i = 0; i < words.length; i++) {
            // reverse the last word
            if (i == words.length - 1) {
                rangeSwap(words, start, i);
                continue;
            }
            
            // once meet the space, reverse the word front of it
            if (words[i] == ' ' && i >= 1) {
                rangeSwap(words, start, i - 1);
                start = i + 1;
            }
        }
    }

    /**
     * reverse the characters within range from start to end
     */
    private static void rangeSwap(char[] words, int start, int end) {
        while (start < end) {
            swap(words, start++, end--);
        }
    }

    // reserve two characters in char array by two indexs
    private static void swap(char[] words, int left, int right) {
        char tmp = words[left];
        words[left] = words[right];
        words[right] = tmp;
    }


    // Given an input string , reverse the string word by word. 

    // Example:
    // Input:  ['t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e']
    // Output: ['b','l','u','e',' ','i','s',' ','s','k','y',' ','t','h','e']
    public static void main(String[] args) {
        char[] input = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        reverseWords(input);
        System.out.println(Arrays.toString(input));
    }
}