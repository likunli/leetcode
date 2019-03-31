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
    static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size--;
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return 0;
    }

    // Given a binary tree, find its minimum depth.

    // The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

    // Note: A leaf is a node with no children.

    // Example:

    // Given binary tree [3,9,20,null,null,15,7],

    //     3
    //    / \
    //   9  20
    //     /  \
    //    15   7
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int depth = minDepth(root);
        System.out.println(depth);
    }
}