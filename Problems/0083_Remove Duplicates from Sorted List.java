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
        if (head == null || head.next == null) return head;
        ListNode l1 = head.next;
        ListNode l2 = head;
        while (l1 != null) {
            if (l1.val == l2.val) {
                l1 = l1.next;
            } else {
                l2.next = l1;
                l2 = l1;
                l1 = l1.next;
            }
        }
        l2.next = null;
        return head;
    }
}
