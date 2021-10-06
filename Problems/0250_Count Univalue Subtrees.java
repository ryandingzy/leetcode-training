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
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root != null) search(root);
        return count;
    }
    
    public int search(TreeNode root) {
        if (root.left == null && root.right == null) {
            count++;
            return root.val;
        }
        if (root.left == null) {
            if (search(root.right) != root.val) return -1001;
            else {
                count++;
                return root.val;
            }
        }
        if (root.right == null) {
            if (search(root.left) != root.val) return -1001;
            else {
                count++;
                return root.val;
            }
        }
        int leftVal = search(root.right);
        int rightVal = search(root.left);
        if (leftVal != root.val) return -1001;
        if (rightVal != root.val) return -1001;
        count++;
        return root.val;
    }
}
