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
    Set<Integer> valSet;
    public boolean findTarget(TreeNode root, int k) {
        valSet = new HashSet<>();
        return recursion(root, k);
    }

    private boolean recursion(TreeNode root, int k) {
        if (root == null) return false;
        if (valSet.contains(k - root.val)) return true;
        valSet.add(root.val);
        if (recursion(root.left, k)) return true;
        return recursion(root.right, k);
    }
}
