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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 1;
        ListNode n1 = head;
        while (n1 != null && count < n) {
            n1 = n1.next;
            count++;
        }
        // not enough
        if (n1 == null) return head;
        // delete head
        if (n1.next == null) {
            head = head.next;
            return head;
        }
        // other
        n1 = n1.next;
        ListNode n2 = head;
        while (n1!= null && n1.next != null) {
            n1 = n1.next;
            n2 = n2.next;
        }
        n2.next = n2.next.next;
        
        return head;
    }
}
