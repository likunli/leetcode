/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     public $val = null;
 *     public $left = null;
 *     public $right = null;
 *     function __construct($value) { $this->val = $value; }
 * }
 */
class Solution {

    /**
     * @param TreeNode $root
     * @return Integer
     */
    function maxDepth($root) {
        if ($root == null) {
            return 0;
        }
        return $this->helper($root, 0);
    }
    
    function helper($root, $depth) {
        $depth += 1;
        $leftMaxDepth = is_null($root->left) ? $depth : $this->helper($root->left, $depth) ;
        $rightMaxDepth = is_null($root->right) ? $depth : $this->helper($root->right, $depth);
        return max($leftMaxDepth, $rightMaxDepth);
    }
}
