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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == null && q == null;
        if (p.val != q.val) return false;
        if (p.left == null || q.left == null) {
            if (!(p.left == null && q.left == null)) return false;
        } else {
            if (!isSameTree(p.left, q.left)) return false;
        }
        if (p.right == null || q.right == null) {
            if (!(p.right == null && q.right == null)) return false;
        } else {
            if (!isSameTree(p.right, q.right)) return false;
        }
        return true;
    }
}
