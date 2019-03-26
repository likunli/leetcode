import java.util.*;

class Solution {


    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, 0, new ArrayList<>());
        return res;
    }

    private static void helper(List<List<Integer>> res, int[] nums, int currrentIndex, List<Integer> tmp) {
        if (currrentIndex == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(nums[currrentIndex]);
        helper(res, nums, currrentIndex + 1, tmp);
        tmp.remove(new Integer(nums[currrentIndex]));
        helper(res, nums, currrentIndex + 1, tmp);
    }

    // Given a set of distinct integers, nums, return all possible subsets (the power set).

    // Note: The solution set must not contain duplicate subsets.

    // Example:

    // Input: nums = [1,2,3]
    // Output:
    // [
    // [3],
    // [1],
    // [2],
    // [1,2,3],
    // [1,3],
    // [2,3],
    // [1,2],
    // []
    // ]
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets(nums);
        for (List<Integer> record : result) {
            System.out.println(record);
        }
    }
}