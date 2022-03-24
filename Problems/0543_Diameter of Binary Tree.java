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
    public int diameterOfBinaryTree(TreeNode root) {
        getLen(root);
        return max;
    }
    
    private int getLen(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        } else if (root.left == null) {
            int rLen = getLen(root.right);
            max = Math.max(max, rLen + 1);
            return rLen + 1;
        } else if (root.right == null) {
            int lLen = getLen(root.left);
            max = Math.max(max, lLen + 1);
            return lLen + 1;
        } else {
            int rLen = getLen(root.right);
            int lLen = getLen(root.left);
            max = Math.max(max, rLen + lLen + 2);
            return Math.max(rLen, lLen) + 1;
        }
    }
}
