import java.util.*;

class Solution {


    // time O(nlogn) -> sort method 

    // time O(1) -> two pass
    // compress and then flatten

    static int findUnsortedSubarray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        // compress
        while (start + 1 < nums.length && nums[start] <= nums[start + 1]) {
            start++;
        }

        if (start >= end) {
            return 0;
        }

        while (end - 1 >= 0 && nums[end] >= nums[end - 1]) {
            end--;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        // flatten
        while (start - 1 >= 0 && nums[start - 1] > min) {
            start--;
        }

        while (end + 1 <= nums.length - 1 && nums[end + 1] < max) {
            end++;
        }
        return end - start + 1;        
    }

    // Given an integer array, you need to find one continuous subarray that 
    // if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

    // You need to find the shortest such subarray and output its length.
    
    // Example 1:
    // Input: [2, 6, 4, 8, 10, 9, 15]
    // Output: 5
    // Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
    public static void main(String[] args) {
        int[] nums = {1,3,2,2,2};
        int result = findUnsortedSubarray(nums);
        System.out.println(result);
    }
}