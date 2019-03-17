import java.util.*;

class Solution {
    // 0 1 2 3 4
    // 3 4 5 1 2

    static int findMin(int[] input) {
        int start = 0;
        int end = input.length - 1;

        while (start < end) {
            int mid = start - (start - end) / 2;
            
            if (input[mid] > input[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        // start == end
        // start ------ mid ----- end
        return input[start];
    }



    // Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

    // (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

    // Find the minimum element.

    // You may assume no duplicate exists in the array.

    // Input: [3,4,5,1,2] 
    // Output: 1

    // Input: [4,5,6,7,0,1,2]
    // Output: 0
    public static void main(String[] args) {
        int[] input = {4, 5, 6, 7, 0, 1, 2};
        int result = findMin(input);
        System.out.println(result);
    }
}