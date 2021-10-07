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
    public int closestValue(TreeNode root, double target) {
        if (target == root.val) return root.val;
        if (target > root.val && root.right != null) {
            int rightVal = closestValue(root.right, target);
            if (Math.abs(target - rightVal) < Math.abs(target - root.val)) {
                return rightVal;
            } else {
                return root.val;
            }
        }
        if (target < root.val && root.left != null) {
            int leftVal = closestValue(root.left, target);
            if (Math.abs(target - leftVal) < Math.abs(target - root.val)) {
                return leftVal;
            } else {
                return root.val;
            }
        }
        return root.val;
    }
}
