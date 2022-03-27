/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        if (head.next == head) {
            head.next = newNode;
            newNode.next = head;
            return head;
        }
        Node next = head.next;
        Node pre = head;
        boolean init = true;
        while (init || pre != head) {
            init = false;
            if (next.val > pre.val) {
                if (next.val >= insertVal && pre.val <= insertVal) {
                    pre.next = newNode;
                    newNode.next = next;
                    return head;
                }
            } else if (next.val < pre.val) {
                if (insertVal <= next.val || insertVal >= pre.val) {
                    pre.next = newNode;
                    newNode.next = next;
                    return head;
                }
            }
            pre = next;
            next = next.next;
        }
        pre.next = newNode;
        newNode.next = next;
        return head;
    }
}
