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
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        return dfs(root)[3];
    }
    
    public int[] dfs(TreeNode root) {
        int[] res = new int[4];
        // leaf node
        if (root.left == null && root.right == null) {
            res[0] = 1;
            res[1] = root.val;
            res[2] = root.val;
            res[3] = 1;
            return res;
        }
        // left null
        if (root.left == null) {
            int[] rRes = dfs(root.right);
            if (rRes[0] == 0 || root.val >= rRes[1]) {
                res[3] = rRes[3];
                return res;
            }
            res[0] = 1;
            res[1] = root.val;
            res[2] = rRes[2];
            res[3] = rRes[3] + 1;
            return res;
        }
        // right null
        if (root.right == null) {
            int[] lRes = dfs(root.left);
            if (lRes[0] == 0 || root.val <= lRes[2]) {
                res[3] = lRes[3];
                return res;
            }
            res[0] = 1;
            res[1] = lRes[1];
            res[2] = root.val;
            res[3] = lRes[3] + 1;
            return res;
        }
        // other
        int[] lRes = dfs(root.left);
        int[] rRes = dfs(root.right);
        if (lRes[0] == 0 || rRes[0] == 0 || root.val <= lRes[2] || root.val >= rRes[1]) {
            res[3] = Math.max(lRes[3], rRes[3]);
            return res;
        }
        res[0] = 1;
        res[1] = lRes[1];
        res[2] = rRes[2];
        res[3] = lRes[3] + rRes[3] + 1;
        return res;
    }
}
