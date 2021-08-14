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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        if (root == null) return lst;
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        TreeNode cur = root;
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peekLast();
            if (peek.left != null && cur != peek.left && cur != peek.right) {
                stack.addLast(peek.left);
            } else if (peek.right != null && cur != peek.right) {
                stack.addLast(peek.right);
            } else {
                lst.add(stack.pollLast().val);
                cur = peek;
            }
        }
        return lst;
    }
}
