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
    boolean balanced = true;
    
    public boolean isBalanced(TreeNode root) {
        if (root != null) getHeight(root);
        return balanced;
    }
    
    public int getHeight(TreeNode root) {
        if (!balanced) return 0;
        
        if (root == null) return 0;
        int heightLeft = getHeight(root.left);
        int heightRight = getHeight(root.right);
        if (Math.abs(heightLeft - heightRight) > 1) {
            balanced = false;
            return 0;
        } else {
            return Math.max(heightLeft, heightRight) + 1;
        }
    }
}

// 可以用一种不符合常规的数字来代替这里的boolean值
class Solution {
    public boolean isBalanced(TreeNode root) {
        return balanced(root) != -1;
    }

    private int balanced(TreeNode node) {
        if (node == null) return 0;
        int leftHeight, rightHeight;
        if ((leftHeight = balanced(node.left)) == -1
                || (rightHeight = balanced(node.right)) == -1
                || Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
