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
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = reverse(l1);
        ListNode head2 = reverse(l2);
        ListNode id1 = head1;
        ListNode id2 = head2;
        ListNode res = new ListNode();
        ListNode cur = res;
        int next = 0;
        while (id1 != null && id2 != null) {
            int sum = id1.val + id2.val + next;
            cur.next = new ListNode(sum % 10);
            next = sum / 10;
            cur = cur.next;
            id1 = id1.next;
            id2 = id2.next;
        }
        while (id1 != null) {
            int sum = id1.val + next;
            cur.next = new ListNode(sum % 10);
            next = sum / 10;
            cur = cur.next;
            id1 = id1.next;
        }
        while (id2 != null) {
            int sum = id2.val + next;
            cur.next = new ListNode(sum % 10);
            next = sum / 10;
            cur = cur.next;
            id2 = id2.next;
        }
        if (next > 0) {
            cur.next = new ListNode(next);
        }
        return reverse(res.next);
    }
}
