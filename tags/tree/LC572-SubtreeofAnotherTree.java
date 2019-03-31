import java.util.*;

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}

// note
// travel the whole in a topological order
// once we find a value that equals to the value of the target tree's root
// we check if its subtree is same to that target tree
// transfer the question to a sub-question that whether two trees are same
class Solution {

    static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(s);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.val == t.val) {
                if (isSameTree(cur, t)) {
                    return true;
                }
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return false;
    }


    private static Boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }

        if (s.val != t.val) {
            return false;
        } else {
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }
    }

    // Given two non-empty binary trees s and t, 
    // check whether tree t has exactly the same structure and node values with a subtree of s. 
    // A subtree of s is a tree consists of a node in s and all of this node's descendants. 
    // The tree s could also be considered as a subtree of itself.

    // Example 1:
    // Given tree s:
    
    //      3
    //     / \
    //    4   5
    //   / \
    //  1   2
    // Given tree t:
    //    4 
    //   / \
    //  1   2
    // Return true, because t has the same structure and node values with a subtree of s.
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        boolean result = isSubtree(root, root.left);
        System.out.println(result);
    }
}