/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node newHead = new Node(head.val);
        map.put(head, newHead);
        
        Node oriNode = head;
        Node newNode = newHead;
        while (oriNode.next != null) {
            Node nextNode = new Node(oriNode.next.val);
            map.put(oriNode.next, nextNode);
            newNode.next = nextNode;
            newNode = nextNode;
            oriNode = oriNode.next;
        }
        oriNode = head;
        newNode = newHead;
        while (oriNode != null) {
            if (oriNode.random != null) {
                newNode.random = map.get(oriNode.random);
            }
            oriNode = oriNode.next;
            newNode = newNode.next;
        }
        return newHead;
    }
}
