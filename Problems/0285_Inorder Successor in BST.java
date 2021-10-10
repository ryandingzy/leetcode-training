/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur.val != p.val) {
            if (cur.val > p.val) {
                pre = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if (cur.right == null) return pre;
        cur = cur.right;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }
}
