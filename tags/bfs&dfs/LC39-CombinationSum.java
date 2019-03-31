import java.util.*;

class Solution {

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                if (candidates[i] <= target) {
                    currentList.add(candidates[i]);
                    dfs(res, candidates, target - candidates[i], currentList, i);
                    currentList.remove(new Integer(candidates[i]));
                } else {
                    break;
                }
            }
        }
    }

    // Given a set of candidate numbers (candidates) (without duplicates) and a
    // target number (target),
    // find all unique combinations in candidates where the candidate numbers sums
    // to target.

    // The same repeated number may be chosen from candidates unlimited number of
    // times.
    // Note:

    // All numbers (including target) will be positive integers.
    // The solution set must not contain duplicate combinations.
    // Example 1:

    // Input: candidates = [2,3,6,7], target = 7,
    // A solution set is:
    // [
    // [7],
    // [2,2,3]
    // ]
    public static void main(String[] args) {
        int[] candidates = { 8, 7, 4, 3 };
        int target = 11;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);
    }
}