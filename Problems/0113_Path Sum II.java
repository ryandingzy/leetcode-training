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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> lsts = new ArrayList<>();
        if (root == null) return lsts;
        List<Integer> lst = new ArrayList<>();
        dfs(root, targetSum, lsts, lst);
        return lsts;
    }
    
    public void dfs(TreeNode root, int targetSum, List<List<Integer>> lsts, List<Integer> lst) {
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                lst.add(root.val);
                lsts.add(new ArrayList<>(lst));
                lst.remove(lst.size() - 1);
            }
            return;
        }
        if (root.left != null) {
            lst.add(root.val);
            dfs(root.left, targetSum - root.val, lsts, lst);
            lst.remove(lst.size() - 1);
        }
        if (root.right != null) {
            lst.add(root.val);
            dfs(root.right, targetSum - root.val, lsts, lst);
            lst.remove(lst.size() - 1);
        }
    }
}
