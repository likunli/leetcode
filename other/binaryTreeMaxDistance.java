import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

class Solution {

    static int findMaxLength(TreeNode root) {

        // case 1 : at left child
        // case 2 : at right child
        // case 3 : go through the root node
        if (root == null) {
            return 0;
        }

        int leftMaxDistance = findMaxLength(root.left);
        int rightMaxDistance = findMaxLength(root.right);

        int leftMaxHeight = height(root.left);
        int rightMaxHeight = height(root.right);

        return Math.max(Math.max(leftMaxDistance, rightMaxDistance), leftMaxHeight + rightMaxHeight);
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    /*
     * input: 
     *              1
     *             2 3 
     *            4
     * 
     * result: 3
     */

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        int length = findMaxLength(root);
        System.out.println(length);
    }
}