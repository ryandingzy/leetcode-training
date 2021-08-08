/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Node {
    TreeNode treeNode;
    int level;
    Node() {}
    Node(TreeNode treeNode, int level) { 
        this.treeNode = treeNode;
        this.level = level;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 1));
        
        List<List<Integer>> lsts = new ArrayList<>();
        if (root == null)
            return lsts;
        
        List<Integer> lst = new ArrayList<>();
        lst.add(root.val);
        int currLevel = 1;
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.treeNode.left == null && node.treeNode.right == null) continue;
            
            if (node.level + 1 > currLevel) {
                lsts.add(lst);
                lst = new ArrayList<>();
                currLevel++;
            }

            if (node.treeNode.left != null) {
                lst.add(node.treeNode.left.val);
                queue.offer(new Node(node.treeNode.left, node.level + 1));
            }
            if (node.treeNode.right != null) {
                lst.add(node.treeNode.right.val);
                queue.offer(new Node(node.treeNode.right, node.level + 1));
            }
        }
        if (!lst.isEmpty()) lsts.add(lst);
        
        return lsts;
    }
}
