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
    Set<String> seqTreeSet;
    Set<String> resSet;
    List<TreeNode> res;

    private String recursion(TreeNode root) {
        if (root == null) return "";
        String id = Integer.toString(root.val) + "(" + recursion(root.left) + ")(" + recursion(root.right) + ")";
        if (seqTreeSet.contains(id)) {
            if (!resSet.contains(id)) {
                resSet.add(id);
                res.add(root);
            }
        } else {
            seqTreeSet.add(id);
        }
        return id;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        seqTreeSet = new HashSet<>();
        resSet = new HashSet<>();
        res = new ArrayList<>();
        recursion(root);
        return res;
    }
}
