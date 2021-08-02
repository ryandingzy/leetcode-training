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
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> lst = new ArrayList<>();
        ListNode l;
        for (int i = 0; i < lists.length; i++) {
            l = lists[i];
            while (l != null) {
                lst.add(l.val);
                l = l.next;
            }
        }
        
        if (lst.size() == 0) return null; 
        
        Collections.sort(lst);

        ListNode h = new ListNode(lst.get(0));
        l = h;
        
        for (int i = 1; i < lst.size(); i++) {
            l.next = new ListNode(lst.get(i));
            l = l.next;
        }
        
        return h;
    }
}

// PriorityQueue
class Solution {
    class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        public int compareTo(Status status2) {
            return this.val - status2.val;
        }
    }

    PriorityQueue<Status> queue = new PriorityQueue<Status>();

    public ListNode mergeKLists(ListNode[] lists) {
        for (ListNode node: lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            Status f = queue.poll();
            tail.next = f.ptr;
            tail = tail.next;
            if (f.ptr.next != null) {
                queue.offer(new Status(f.ptr.next.val, f.ptr.next));
            }
        }
        return head.next;
    }
}
