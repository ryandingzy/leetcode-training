/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node recursion(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (true) {
            Node next = cur.next;
            Node childTail = cur;
            if (cur.child != null) {
                childTail = recursion(cur.child);

                cur.next = cur.child;
                cur.next.prev = cur;
                cur.child = null;
                
                childTail.next = next;
                if (next != null)
                    next.prev = childTail;
            }
            if (next == null) {
                return childTail;
            }
            cur = next;
        }
    }

    public Node flatten(Node head) {
        recursion(head);
        return head;
    }
}
