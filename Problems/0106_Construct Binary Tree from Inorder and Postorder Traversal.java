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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    public TreeNode buildTree(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
        // 0
        if (inend - instart + 1 < 1) return null;
        // 1
        TreeNode root = new TreeNode(postorder[postend]);
        if (inend - instart + 1 == 1) return root;
        // more
        for (int i = instart; i <= inend; i++) {
            if (inorder[i] == postorder[postend]) {
                root.left = buildTree(inorder, instart, i - 1, postorder, poststart, poststart + i - instart - 1);
                root.right = buildTree(inorder, i + 1, inend, postorder, poststart + i - instart, postend - 1);
            }
        }
        return root;
    }
}
