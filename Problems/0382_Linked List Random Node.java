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
    List<Integer> lst = new ArrayList<>();
    HashMap<Integer, ListNode> map = new HashMap<>();
    
    public Solution(ListNode head) {
        while (head != null) {
            lst.add(head.val);
            map.put(head.val, head);
            head = head.next;
        }
    }
    
    public int getRandom() {
        Random rd = new Random();
        return lst.get(rd.nextInt(lst.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
 