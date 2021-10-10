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
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        getLongest(root);
        return max;
    }
    
    private int getLongest(TreeNode root) {
        int leftVal;
        if (root.left == null) leftVal = 1;
        else {
            int num = getLongest(root.left);
            if (root.left.val == root.val + 1) leftVal = num + 1;
            else leftVal = 1;
        }
        int rightVal;
        if (root.right == null) rightVal = 1;
        else {
            int num = getLongest(root.right);
            if (root.right.val == root.val + 1) rightVal = num + 1;
            else rightVal = 1;
        }
        int res = Math.max(leftVal, rightVal);
        max = Math.max(max, res);
        return res;
    }
}
