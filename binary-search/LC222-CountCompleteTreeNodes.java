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

    // given binary three is completed binary tree, so
    // always find the left to find out the depth of the given tree

    // then, use the method that like sort of binary search to find the count of the nodes of the last line nodes
    static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return 1;
        }

        TreeNode tmp = root;
        int height = 0;
        int sum = 0;
        while (tmp.left != null) {
            // 1 << height -> 2 ^ height
        
            sum += (1 << height);
            tmp = tmp.left;
            height++;
        }
        return sum + checkLastLine(root, height);
    }

    private static int checkLastLine(TreeNode root, int height) {
        if (height == 1) {
            if (root.left == null) {
                return 0;
            } else {
                if (root.right == null) {
                    return 1;
                } else {
                    return 2;
                }
            }
        }
        int currentHeight = 1;
        TreeNode midNode = root.left;
        while (currentHeight < height) {
            midNode = midNode.right;
            currentHeight++;
        }

        if (midNode == null) {
            return checkLastLine(root.left, height - 1);
        } else {
            return (1 << (height - 1)) + checkLastLine(root.right, height - 1);
        }
    }

    // most important thing need noticed is that the given tree is a complete binary tree
    // Given a complete binary tree, count the number of nodes.

    // Note:
    // Definition of a complete binary tree from Wikipedia:
    // In a complete binary tree every level, except possibly the last, 
    // is completely filled, and all nodes in the last level are 
    // as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

    // Example:
    // Input: 
    //     1
    //    / \
    //   2   3
    //  / \  /
    // 4  5 6

    // Output: 6

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        int minNodes = countNodes(root);
        System.out.println(minNodes);
    }
}