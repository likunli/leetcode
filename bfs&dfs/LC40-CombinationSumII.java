import java.util.*;

class Solution {

    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        dfs(res, candidates, target, new ArrayList<Integer>(), 0);
        return res;
    }

    // dfs
    private static void dfs(List<List<Integer>> res, int[] candidates, int target, List<Integer> currentList,
            int start) {
        //System.out.println(currentList + "===target: " + target);
        if (target == 0) {
            // append new result
            List<Integer> tmp = new ArrayList<>(currentList);
            res.add(tmp);
        } else {
            for (int i = start; i < candidates.length; i++) {
                int currentValue = candidates[i];
                if (currentValue <= target) {
                    currentList.add(currentValue);
                    dfs(res, candidates, target - currentValue, currentList, i + 1);
                    currentList.remove(new Integer(currentValue));
                } else {
                    break;
                }
                while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
                    i++;
                }
            }
        }
    }


    // Given a collection of candidate numbers (candidates) and a target number (target), 
    // find all unique combinations in candidates where the candidate numbers sums to target.

    // Each number in candidates may only be used once in the combination.

    // Note:

    // All numbers (including target) will be positive integers.
    // The solution set must not contain duplicate combinations.
    // Example 1:

    // Input: candidates = [10,1,2,7,6,1,5], target = 8,
    // A solution set is:
    // [
    // [1, 7],
    // [1, 2, 5],
    // [2, 6],
    // [1, 1, 6]
    // ]
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> result = combinationSum2(candidates, target);
        System.out.println(result);
    }
}