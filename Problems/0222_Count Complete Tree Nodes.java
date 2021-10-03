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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode leftNode = root;
        int leftLevel = 0;
        while (leftNode.left != null) {
            leftNode = leftNode.left;
            leftLevel++;
        }
        TreeNode rightNode = root;
        int rightLevel = 0;
        while (rightNode.right != null) {
            rightNode = rightNode.right;
            rightLevel++;
        }
        if (rightLevel == leftLevel) return (int)Math.pow(2, leftLevel + 1) - 1;
        else return binarySearch(root, 0, leftLevel, 0, false);
    }
    
    public int binarySearch(TreeNode root, int num, int n, int currLevel, boolean needCalLeft) {
        int leftLevel = n;
        if (needCalLeft) {
            leftLevel = currLevel;
            int tempNum = num;
            TreeNode node = root;
            while (node.left != null) {
                node = node.left;
                leftLevel++;
                tempNum = tempNum * 2 + 1;
            }
            if (leftLevel != n) return tempNum * 2 + 1;
        }
        
        if (n - currLevel == 1) return num * 2 + 2;
        
        TreeNode nextRoot = root.left;
        int midLevel = currLevel + 1;
        while (nextRoot.right != null) {
            nextRoot = nextRoot.right;
            midLevel++;
        }
        if (midLevel != n) return binarySearch(root.left, num * 2 + 1, n, currLevel + 1, false);
        else return binarySearch(root.right, num * 2 + 2, n, currLevel + 1, true);
    }
}
