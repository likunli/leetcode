import java.util.*;

class Solution {

    static int longestConsecutive(int[] nums) {
        int maxLength = 0;
        Set<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num);
        }
        for (int i = 0; i < nums.length; i++) {

            int len = 1;

            int cur = nums[i];
            st.remove(cur);
            while (st.contains(--cur)) {
                len++;
                st.remove(cur);
            }

            cur = nums[i];
            while (st.contains(++cur)) {
                len++;
                st.remove(cur);
            }
            maxLength = Math.max(maxLength, len);
        }
        return maxLength;
    }

    // Given an unsorted array of integers, 
    // find the length of the longest consecutive elements sequence.

    // Your algorithm should run in O(n) complexity.

    // Example:
    // Input: [100, 4, 200, 1, 3, 2]
    // Output: 4
    // Explanation: 
    // The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

    public static void main(String[] args) {
        int[] input = {100, 4, 200, 1, 3, 2};
        int length = longestConsecutive(nums);
        System.out.println(length);
    }
}