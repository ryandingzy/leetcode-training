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
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    private int dfs(TreeNode root, boolean isLeft) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null) {
            if (isLeft) {
                return root.val;
            } else {
                return 0;
            }
        }
        int res = 0;
        if (left != null) {
            res += dfs(left, true);
        }
        if (right != null) {
            res += dfs(right, false);
        }
        return res;
    }
}
