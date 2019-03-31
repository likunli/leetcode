import java.util.*;

class Solution {

    static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - 1 != i && nums[nums[i] - 1] - 1 != nums[i] - 1) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                res.add(i + 1);
            }
        }
        return res;
    }

    private static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    // Given an array of integers where 1 <= a[i] <= n (n = size of array), 
    // some elements appear twice and others appear once.

    // Find all the elements of [1, n] inclusive that do not appear in this array.

    // Could you do it without extra space and in O(n) runtime? 
    // You may assume the returned list does not count as extra space.

    // Example:
    // Input:
    // [4,3,2,7,8,2,3,1]

    // Output:
    // [5,6]
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> res = findDisappearedNumbers(nums);
        System.out.println(res);
    }
}