import java.util.*;

class Solution {

    static List<List<Integer>> threeSum(int[] input) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(input);

        for (int i = 0; i < input.length - 2; i++) {
            // first number 
            int pivot = input[i];
            // start number after pivot
            int start = i + 1;
            // end number
            int end = input.length - 1;
            // using two pointers tech after each pivot
            while (start < end) {
                if (input[start] + input[end] + pivot == 0) {
                    res.add(Arrays.asList(pivot, input[start], input[end]));
                    while (start + 1 < input.length && input[start] == input[start + 1]) {
                        start++;
                    }
    
                    while (end - 1>= 0 && input[end] == input[end - 1]) {
                        end--;
                    }
                    start++;
                    end--;
                } else if (input[start] + input[end] + pivot < 0) {
                    start++;
                } else {
                    end--;
                }

                while (i < input.length - 2 && input[i] == input[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }

    

    // Given an array nums of n integers, are there elements a, b, c in nums such
    // that a + b + c = 0? Find all unique triplets in the array which gives the sum
    // of zero.
    // Note:
    // The solution set must not contain duplicate triplets.
    // Example:
    // Given array nums = [-1, 0, 1, 2, -1, -4],
    // A solution set is:
    // [
    // [-1, 0, 1],
    // [-1, -1, 2]
    // ]
    public static void main(String[] args) {
        int[] input = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> res = threeSum(input);
        System.out.println(res);
    }
}