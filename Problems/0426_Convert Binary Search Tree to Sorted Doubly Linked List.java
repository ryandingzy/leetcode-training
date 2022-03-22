/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        Node[] bound = recursion(root);
        bound[0].left = bound[1];
        bound[1].right = bound[0];
        return bound[0];
    }
    
    public Node[] recursion(Node root) {
        Node rLeft = null, rRight = null, lLeft = null, lRight = null;
        if (root.left == null && root.right == null) {
            return new Node[]{root, root};
        } else if (root.left == null) {
            Node[] bound = recursion(root.right);
            root.right = bound[0];
            bound[0].left = root;
            return new Node[]{root, bound[1]};
        } else if (root.right == null) {
            Node[] bound = recursion(root.left);
            root.left = bound[1];
            bound[1].right = root;
            return new Node[]{bound[0], root};
        } else {
            Node[] bl = recursion(root.left);
            Node[] br = recursion(root.right);
            root.left = bl[1];
            bl[1].right = root;
            root.right = br[0];
            br[0].left = root;
            return new Node[]{bl[0], br[1]};
        }
    }
}
