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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode newHead = new ListNode(-501, head);
        int count = 1;
        ListNode l =  head, lPre = newHead;
        while (count < left) {
            lPre = l;
            l = l.next;
            count++;
        }
        ListNode leftPtr = l;
        ListNode leftPrePtr = lPre;
        while (count <= right) {
            ListNode temp = l;
            l = l.next;
            temp.next = lPre;
            lPre = temp;
            count++;
        }
        leftPtr.next = l;
        leftPrePtr.next = lPre;
        
        return newHead.next;
    }
}
