/**
 * Definition for a singly-linked list.
 * class ListNode {
 *     public $val = 0;
 *     public $next = null;
 *     function __construct($val) { $this->val = $val; }
 * }
 */
class Solution {

    /**
     * @param ListNode $l1
     * @param ListNode $l2
     * @return ListNode
     */
    function addTwoNumbers($l1, $l2) {
        $dummy = new ListNode(0);
        $cur = $dummy;
        $carry = 0;
        while ($l1 != null || $l2 != null) {
            $sum = ($l1 ? $l1->val : 0) + ($l2 ? $l2->val : 0) + $carry;
            $cur->next = new ListNode($sum % 10);
            $carry = (int) ($sum / 10);
            $cur = $cur->next;
            if ($l1 != null) {
                $l1 = $l1->next;
            }
            if ($l2 != null) {
                $l2 = $l2->next;
            }
        }
        if ($carry != 0) {
            $cur->next = new ListNode($carry);
        }
        return $dummy->next;
    }
}
