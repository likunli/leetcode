import java.util.*;

class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return root;
        }

        // root is one of the successor node for the node p
        if (root.val > p.val) {
            TreeNode closerLeftNode = inorderSuccessor(root.left, p);
            return closerLeftNode == null ? root : closerLeftNode;
        } else {
            return inorderSuccessor(root.right, p);
        }
    }
    // Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
    // The successor of a node p is the node with the smallest key greater than p.val.

    // Example 1:
    //     2
    //    / \
    //   1   3
    // Input: root = [2,1,3], p = 1
    // Output: 2
    // Explanation: 1's in-order successor node is 2. Note that both p and the return value is of TreeNode type.
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode result = inorderSuccessor(root, root.left);
        System.out.println(result.val);
    }
}