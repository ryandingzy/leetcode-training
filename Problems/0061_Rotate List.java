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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode l = head.next;
        int n = 2;
        while (l.next != null) {
            l = l.next;
            n++;
        }
        
        l.next = head;
        int i = 0;
        l = head;
        int breakIdx = (n - 1 + k / n * n - k) % n;
        while (i != breakIdx) {
            l = l.next;
            i++;
        }
        head = l.next;
        l.next = null;
        return head;
    }
}
