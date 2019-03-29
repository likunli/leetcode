import java.util.*;

class Solution {

    // simulate the logic of preOrder visit
    // Time complexity     O (N)
    // Space complexity    O (N)
    static boolean verifyPreorder(int[] preorder) {
        int pre = Integer.MIN_VALUE;
        Deque<Integer> stack = new LinkedList<>();
        for (int node : preorder) {
            if (node < pre) {
                return false;
            }

            while (!stack.isEmpty() && node > stack.peek()) {
                pre = stack.pop();
            }
            stack.push(node);
        }
        return true;
    }

    // Time complexity     O (N)
    // Space complexity    O (1)
    static boolean verifyPreorder2(int[] preorder) {
        int pre = Integer.MIN_VALUE;
        int index = -1;
        for (int node : preorder) {
            if (node < pre) {
                return false;
            }
            while (index >= 0 && node > preorder[index]) {
                pre = preorder[index--];
            }
            preorder[++index] = node;
        }
        return true;
    }


    // Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

    // You may assume each number in the sequence is unique.

    // Consider the following binary search tree: 

    //      5
    //     / \
    //    2   6
    //   / \
    //  1   3

    // Example 1:
    // Input: [5,2,6,1,3]
    // Output: false

    // Example 2:
    // Input: [5,2,1,3,6]
    // Output: true
    public static void main(String[] args) {
        int[] input = {5,2,6,1,3};
        boolean result = verifyPreorder(input);
        System.out.println(result);
    }
}