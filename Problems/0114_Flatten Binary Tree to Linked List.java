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
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        
        TreeNode node = stack.pollLast();
        while (true) {
            if (node.right != null) {
                stack.addLast(node.right);
            }
            if (node.left != null) {
                node.right = node.left;
                TreeNode temp = node;
                node = node.left;
                temp.left = null;
            } else {
                if (!stack.isEmpty()) {
                    TreeNode temp = stack.pollLast();
                    node.right = temp;
                    node.left = null;
                    node = temp;
                } else {
                    break;
                }
            }
        }
    }
}

// Predecessor Node
class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }
}
