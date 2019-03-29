import java.util.*;

class Solution {

    static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }

        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                continue; 
            } else {
                if (pre == nums[i - 1]) {
                    res.add(Integer.toString(nums[i - 1]));
                } else {
                    res.add(new String(pre + "->" + nums[i - 1]));
                }
                pre = nums[i];
            }
        }

        if (pre == nums[nums.length - 1]) {
            res.add(Integer.toString(nums[nums.length - 1]));
        } else {
            res.add(new String(pre + "->" + nums[nums.length - 1]));
        }
        return res;        
    }

    // Given a sorted integer array without duplicates, 
    // return the summary of its ranges.

    // Example 1:

    // Input:  [0,1,2,4,5,7]
    // Output: ["0->2","4->5","7"]
    // Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
    public static void main(String[] args) {
        int[] input = {0,1,2,4,5,7};
        List<String> res = summaryRanges(input);
        System.out.println(res);
    }
}