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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        ListNode l = null;
        int carry = 0;
        int sum = 0;
        // both
        while (l1 != null && l2 != null) {
            if (l == null) {
                l = listNode;
            } else {
                l.next = new ListNode();
                l = l.next;
            }
            sum = carry + l1.val + l2.val;
            carry = sum / 10;
            l.val = sum % 10;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        // single
        while (l1 != null) {
            l.next = new ListNode();
            l = l.next;
            sum = carry + l1.val;
            carry = sum / 10;
            l.val = sum % 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            l.next = new ListNode();
            l = l.next;
            sum = carry + l2.val;
            carry = sum / 10;
            l.val = sum % 10;
            l2 = l2.next;
        }
        // carry
        if (carry != 0) {
            l.next = new ListNode();
            l = l.next;
            l.val = carry;
        }
        
        return listNode;
    }
}
