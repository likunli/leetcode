
import java.util.*;


class Solution {

    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int start = 1;
        int count = 1;
        int pre = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre) {
                count++;
                if (count <= 2) {
                    swap(nums, i, start++);
                }
            } else {
                pre = nums[i];
                count = 1;
                swap(nums, i, start++);
            }
        }
        return start;
    }

    private static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    private static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    // Given a sorted array nums, 
    // remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

    // Do not allocate extra space for another array, 
    // you must do this by modifying the input array in-place with O(1) extra memory.

    // Example 1:

    // Given nums = [1,1,1,2,2,3],

    // Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

    // It doesn't matter what you leave beyond the returned length.
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int result = removeDuplicates(nums);
        for (int i = 0; i < result; i++) {
            System.out.println(nums[i]);
        }
    }
}