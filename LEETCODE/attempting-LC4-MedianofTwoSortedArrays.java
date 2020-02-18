import java.util.*;

class Solution {

    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int len1 = nums1.length;
        int len2 = nums2.length;

        int count = len
    }

    // There are two sorted arrays nums1 and nums2 of size m and n respectively.

    // Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

    // You may assume nums1 and nums2 cannot be both empty.

    // Example 1:

    // nums1 = [1, 3]
    // nums2 = [2]

    // The median is 2.0
    // Example 2:

    // nums1 = [1, 2]
    // nums2 = [3, 4]

    // The median is (2 + 3)/2 = 2.5
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }
}