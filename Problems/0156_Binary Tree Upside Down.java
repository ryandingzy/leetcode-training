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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // base case: we can backtrack now
        if (root == null || root.left == null)
            return root;
        
        // get the lest most node as the head
        TreeNode head = upsideDownBinaryTree(root.left);
        
        // connect upside down, root.left.left -> right, root.left.right -> root
        root.left.left = root.right;
        root.left.right = root;
        
        // make sure to disconnect the cycles
        root.left = null;
        root.right = null;
        
        // return the new head
        return head;
    }
}
