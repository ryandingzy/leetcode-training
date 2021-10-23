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
    public ListNode plusOne(ListNode head) {
        int carry = add(head);
        if (carry == 1) {
            return new ListNode(1, head);
        } else {
            return head;
        }
    }
    
    public int add(ListNode node) {
        if (node.next == null) {
            node.val++;
            if (node.val > 9) {
                node.val %= 10;
                return 1;
            } else {
                return 0;
            }
        }

        node.val += add(node.next);
        if (node.val > 9) {
            node.val %= 10;
            return 1;
        } else {
            return 0;
        }
    }
}
