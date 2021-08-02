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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode bounder = head;
        // check this k elem
        for (int i = 0; i < k; i++) {
            if (bounder == null) return head;
            if (i < k - 1) {
                bounder = bounder.next;
            }
        }
        ListNode thisTail = bounder;

        // check next k elem
        bounder = bounder.next;
        ListNode nextHead = bounder;
        int j = 0;
        for (j = 0; j < k; j++) {
            if (bounder == null) {
                break;
            }
            if (j < k -1)
                bounder = bounder.next;
        }
        // record neck
        ListNode neck = head.next;
        
        // set head.next
        if (j < k) {
            head.next = nextHead;
        } else {
            head.next = bounder;
        }
        
        // recursion
        reverseKGroup(nextHead, k);
        
        // set other elem except head
        reverseOther(neck, k - 1);
        neck.next = head;
        
        return thisTail;
    }
    
    public void reverseOther(ListNode head, int num) {
        if (num <= 1) return;
        reverseOther(head.next, num - 1);
        head.next.next = head;
    }
}
