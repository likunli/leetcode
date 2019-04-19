import java.util.*;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution {

    static ListNode removeNodes(ListNode head, int target) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tmp = head;
        ListNode pre = dummy;
        while (tmp != null) {
            if (tmp.val > target) {
                pre.next = tmp.next;
            } else {
                pre = tmp;
            }
            tmp = tmp.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(100);
        head.next = new ListNode(105);
        head.next.next = new ListNode(50);
        ListNode result = removeNodes(head, 100);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}