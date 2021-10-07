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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder(Integer.toString(root.val));
        if (root.left != null) dfs(root.left, sb, res);
        if (root.right != null) dfs(root.right, sb, res);
        if (root.left == null && root.right == null) res.add(sb.toString());
        return res;
    }
    
    public void dfs(TreeNode root, StringBuilder sb, List<String> res) {
        int length = sb.length();
        sb.append("->");
        sb.append(Integer.toString(root.val));
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        }
        if (root.left != null) dfs(root.left, sb, res);
        if (root.right != null) dfs(root.right, sb, res);
        sb.setLength(length);
    }
}
