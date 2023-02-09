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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        TreeNode helpNode = new TreeNode();
        helpNode.right = root;

        TreeNode node = root;
        TreeNode pre = helpNode;
        while (node != null && node.val != key) {
            pre = node;
            if (key > node.val) node = node.right;
            else node = node.left;
        }
        if (node == null) return root;
        if (node.left == null) {
            if (pre.left == node) pre.left = node.right;
            else pre.right = node.right;
        } else if (node.right == null) {
            if (pre.left == node) pre.left = node.left;
            else pre.right = node.left;
        } else {
            if (pre.left == node) pre.left = node.left;
            else pre.right = node.left;
            TreeNode tmp = node.left.right;
            node.left.right = node.right;
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            node.left = tmp;
        }
        return helpNode.right;
    }
}
