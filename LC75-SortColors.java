import java.util.*;

class Solution {
  // Input: [2,0,2,1,1,0]
    static void sortColors(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int start = 0;
        int end = nums.length - 1;

        for (int i = 0; i < nums.length && start < end;) {
            if (nums[i] == 0 && i > start) {
                swap(nums, i, start++);
            } else if (nums[i] == 2 && i < end) {
                swap(nums, i, end--);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    // Given an array with n objects colored red, white or blue, 
    // sort them in-place so that objects of the same color are adjacent, 
    // with the colors in the order red, white and blue.

    // Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

    // Note: You are not suppose to use the library's sort function for this problem.

    // Example:

    // Input: [2,0,2,1,1,0]
    // Output: [0,0,1,1,2,2]

    public static void main(String[] args) {
        int[] input = {2,0,2,1,1,0};
        sortColors(input);
        System.out.println(Arrays.toString(input));
    }
}