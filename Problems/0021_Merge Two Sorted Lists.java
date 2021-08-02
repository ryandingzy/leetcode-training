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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        // head
        ListNode h;
        if (l1.val <= l2.val) {
            h = l1;
            l1 = l1.next;
        } else {
            h = l2;
            l2 = l2.next;
        }
        
        ListNode l = h;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                l.next = l1;
                l = l.next;
                l1= l1.next;
            } else {
                l.next = l2;
                l = l.next;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            l.next = l1;
            l = l.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            l.next = l2;
            l = l.next;
            l2 = l2.next;
        }
        return h;
    }
}
