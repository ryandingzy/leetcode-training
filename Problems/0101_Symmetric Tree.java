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
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null || root.right == null)
            return root.left == null && root.right == null;
        else {
            return isSymmetric(root.left, root.right);
        }
    }
    
    public boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1.val != t2.val) return false;
        if (t1.left == null || t2.right == null) {
            if (!(t1.left == null && t2.right == null)) return false;
        } else {
            if (!isSymmetric(t1.left, t2.right)) return false;
        }
        if (t1.right == null || t2.left == null) {
            if (!(t1.right == null && t2.left == null)) return false;
        } else {
            if (!isSymmetric(t1.right, t2.left)) return false;
        }
        return true;
    }
}
