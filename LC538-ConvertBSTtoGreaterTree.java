/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode convertBST(TreeNode root) {
        int[] sum = new int[1];
        sum[0] = 0;
        getSum(root, sum);
        convertToGreaterTree(root, sum);
        return root;
    }
    
    private void getSum(TreeNode root, int[] sum) {
        if (root == null) {
            return;
        }
        
        getSum(root.left, sum);
        sum[0] += root.val;
        getSum(root.right, sum);
    }
    
    private void convertToGreaterTree(TreeNode root, int[] sum) {
        if (root == null) {
            return;
        }
        
        convertToGreaterTree(root.left, sum);
        sum[0] -= root.val;
        root.val += sum[0];
        convertToGreaterTree(root.right, sum);
    }
}