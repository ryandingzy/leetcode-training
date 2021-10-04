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
    public boolean isPalindrome(ListNode head) {
        int n = 0;
        ListNode node = head;
        while (node != null) {
            n++;
            node = node.next;
        }
        if (n == 1) return true;
        ListNode cur = head.next;
        ListNode pre = head;
        for (int i = 0; i < n / 2 - 1; i++) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        if (n % 2 != 0) cur = cur.next;
        for (int i = 0; i < n / 2; i++) {
            if (pre.val != cur.val) return false;
            pre = pre.next;
            cur = cur.next;
        }
        return true;
    }
}
