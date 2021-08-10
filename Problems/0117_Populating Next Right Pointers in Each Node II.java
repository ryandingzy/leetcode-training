/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        // right
        if (root.right != null) {
            Node rootNext = root.next;
            while (rootNext != null) {
                if (rootNext.left != null) {
                    root.right.next = rootNext.left;
                    break;
                }
                if (rootNext.right != null) {
                    root.right.next = rootNext.right;
                    break;
                }
                rootNext = rootNext.next;
            }
        }
        // left
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                Node rootNext = root.next;
                while (rootNext != null) {
                    if (rootNext.left != null) {
                        root.left.next = rootNext.left;
                        break;
                    }
                    if (rootNext.right != null) {
                        root.left.next = rootNext.right;
                        break;
                    }
                    rootNext = rootNext.next;
                }
            }
        }
        
        
        if (root.right != null) connect(root.right);
        if (root.left != null) connect(root.left);
        return root;
    }
}
