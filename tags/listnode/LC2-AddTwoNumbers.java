import java.util.*;

class Solution {

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = carry + l1.val + l2.val;
            cur.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }

        if (l1 == null) {
            while (l2 != null) {
                int sum = carry + l2.val;
                cur.next = new ListNode(sum % 10);
                carry = sum / 10;
                l2 = l2.next;
                cur = cur.next;
            }
        }

        if (l2 == null) {
            while (l1 != null) {
                int sum = carry + l1.val;
                cur.next = new ListNode(sum % 10);
                carry = sum / 10;
                l1 = l1.next;
                cur = cur.next;
            }
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }

    // You are given two non-empty linked lists representing two non-negative integers. 
    // The digits are stored in reverse order and each of their nodes 
    // contain a single digit. Add the two numbers and return it as a linked list.

    // You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    // Example:

    // Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    // Output: 7 -> 0 -> 8
    // Explanation: 342 + 465 = 807.
    
    public static void main(String[] args) {

    }
}