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
    public boolean isValidBST(TreeNode root) {
        long min = (long)Integer.MIN_VALUE - 1;
        long max = (long)Integer.MAX_VALUE + 1;
        return dfs(root, min, max);
    }
    
    public boolean dfs(TreeNode node, long min, long max) {
        if (node.left != null) {
            if (node.left.val >= node.val || node.left.val <= min) return false;
            if (!dfs(node.left, min, node.val)) return false;
        }
        if (node.right != null) {
            if (node.right.val <= node.val || node.right.val >= max) return false;
            if (!dfs(node.right, node.val, max)) return false;
        }
        return true;
    }
}
