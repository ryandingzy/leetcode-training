/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Codec {
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (root == null) return null;
        Queue<Node> qN = new LinkedList<Node>();
        Queue<TreeNode> qTN = new LinkedList<TreeNode>();
        qN.offer(root);
        TreeNode node = new TreeNode(root.val);
        qTN.offer(node);
        while (!qN.isEmpty()) {
            Node curN = qN.poll();
            TreeNode curTN = qTN.poll();
            if (curN.children == null || curN.children.size() == 0) continue;
            TreeNode child = new TreeNode(curN.children.get(0).val);
            curTN.left = child;

            qN.offer(curN.children.get(0));
            qTN.offer(child);
            
            TreeNode it = child;
            for (int i = 1; i < curN.children.size(); i++) {
                TreeNode newChild = new TreeNode(curN.children.get(i).val);
                qN.offer(curN.children.get(i));
                qTN.offer(newChild);

                it.right = newChild;
                it = newChild;
            }
        }
        return node;
    }
	
    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null) return null;
        Queue<Node> qN = new LinkedList<Node>();
        Queue<TreeNode> qTN = new LinkedList<TreeNode>();
        qTN.offer(root);
        Node node = new Node(root.val, new ArrayList<Node>());
        qN.offer(node);
        while (!qTN.isEmpty()) {
            TreeNode curTN = qTN.poll();
            Node curN = qN.poll();
            if (curTN.left == null) continue;
            Node child = new Node(curTN.left.val, new ArrayList<Node>());
            // curN.children = new ArrayList<Node>();
            curN.children.add(child);
            
            qN.offer(child);
            qTN.offer(curTN.left);

            TreeNode it = curTN.left.right;
            while (it != null) {
                Node newChild = new Node(it.val, new ArrayList<Node>());
                curN.children.add(newChild);
                qN.offer(newChild);
                qTN.offer(it);
                it = it.right;
            }
        }
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));
