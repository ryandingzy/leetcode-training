/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode l1 = head.next;
        ListNode l2 = new ListNode(-101, head);
        head = l2;
        boolean same = false;
        while (l1 != null) {
            if (l1.val != l2.next.val) {
                if (same) {
                    l2.next = l1;
                    same = false;
                    l1 = l1.next;
                } else {
                    l2 = l2.next;
                    l1 = l1.next;
                }
            } else {
                same = true;
                l1 = l1.next;
            }
        }
        if (same) {
            l2.next = null;
        }
        return head.next;
    }
}
