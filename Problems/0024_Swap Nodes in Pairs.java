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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode l1 = head;
        ListNode l2 = head.next;
        
        if (l1.next.next == null) {
            l1.next = null;
        } else if (l1.next.next.next == null) {
            l1.next = l1.next.next;
        } else {
            l1.next = l1.next.next.next;
        }
        func (l2.next);
        l2.next = l1;
        return l2;
    }
    
    public void func(ListNode l1) {
        if (l1 == null || l1.next == null) return;
        ListNode l2 = l1.next;
        if (l1.next.next == null) {
            l1.next = null;
        } else if (l1.next.next.next == null) {
            l1.next = l1.next.next;
        } else {
            l1.next = l1.next.next.next;
        }
        func (l2.next);
        l2.next = l1;
    }
}
