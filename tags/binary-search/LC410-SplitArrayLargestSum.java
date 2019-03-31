
import java.util.*;

class Solution {

    static int splitArray(int[] nums, int m) {
        
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        if (nums.length == 1) {
            return sum;
        }

        int left = max;
        int right = sum;
        while (left < right) {
            int mid = left - (left - right) / 2;
            if (valid(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    private static boolean valid(int[] nums, int m, int target) {

        int count = 1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > target) {
                count++;
                sum = num;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
    // sort of cut scope question

    // continuous subarrays.  continuous subarrays.  continuous subarrays.  continuous subarrays. 
    // Given an array which consists of non-negative integers and an integer m, 
    // you can split the array into m non-empty continuous subarrays. 
    // Write an algorithm to minimize the largest sum among these m subarrays.

    // Note:
    // If n is the length of array, assume the following constraints are satisfied:
    
    // 1 <= n <= 1000
    // 1 <= m <= min
    // Examples:
    
    // Input:
    // nums = [7,2,5,10,8]
    // m = 2
    
    // Output:
    // 18
    
    // Explanation:
    // There are four ways to split nums into two subarrays.
    // The best way is to split it into [7,2,5] and [10,8],
    // where the largest sum among the two subarrays is only 18.
    public static void main(String[] args) {
        int[] nums = {7,8,2};
        int m = 2;
        int result = splitArray(nums, m);
        System.out.println(result);
    }
}