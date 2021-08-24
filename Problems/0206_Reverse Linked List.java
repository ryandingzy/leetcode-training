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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode left = head, cur = head.next, right;
        while (cur != null) {
            right = cur.next;
            cur.next = left;
            left = cur;
            cur = right;
        }
        head.next = null;
        return left;
    }
}
