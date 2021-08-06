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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode l1 = new ListNode(-101, head);
        ListNode l2 = l1;
        ListNode l3 = head;
        head = l1;
        while (l3 != null) {
            if (l3.val < x) {
                if (l1 == l2) {
                    l1 = l3;
                    l2 = l3;
                    l3 = l3.next;
                } else {
                    ListNode next = l3.next;
                    l3.next = l1.next;
                    l1.next = l3;
                    l1 = l3;
                    l3 = next;
                    l2.next = l3;
                }
            } else {
                l2 = l3;
                l3 = l3.next;
            }
        }
        return head.next;
    }
}
