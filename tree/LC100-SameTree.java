import java.util.*;

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

class Solution {

    static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        } 

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // Given two binary trees, write a function to check if they are the same or not.
    // Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
    // Example 1:
    // Input:     1         1
    //         / \       / \
    //         2   3     2   3

    //         [1,2,3],   [1,2,3]

    // Output: true
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);

        boolean isSame = isSameTree(root1, root2);
        System.out.println(isSame);
    }
}