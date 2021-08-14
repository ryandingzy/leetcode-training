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
    public ListNode insertionSortList(ListNode head) {
        ListNode res = new ListNode();
        res.next = head;
        ListNode oriNode = head.next;
        head.next = null;
        
        while (oriNode != null) {
            ListNode tmp = oriNode.next;
            ListNode pre = res;
            ListNode cur = res.next;
            while (cur != null && oriNode.val >= cur.val) {
                pre = cur;
                cur = cur.next;
            }
            if (cur == null) {
                pre.next = oriNode;
                oriNode.next = null;
            } else {
                pre.next = oriNode;
                oriNode.next = cur;
            }
            oriNode = tmp;
        }
        return res.next;
    }
}
