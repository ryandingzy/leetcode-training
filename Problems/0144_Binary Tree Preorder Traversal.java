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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        if (root == null) return lst;
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            lst.add(node.val);
            if (node.right != null) stack.addLast(node.right);
            if (node.left != null) stack.addLast(node.left);
        }
        return lst;
    }
}

// Morris
public static void preOrderMorris(TreeNode head) {
	if (head == null) {
		return;
	}
	TreeNode cur1 = head;
	TreeNode cur2 = null;
	while (cur1 != null) {
		cur2 = cur1.left;
		if (cur2 != null) {
			while (cur2.right != null && cur2.right != cur1) {
				cur2 = cur2.right;
			}
			if (cur2.right == null) {
				cur2.right = cur1;
				System.out.print(cur1.value + " ");
				cur1 = cur1.left;
				continue;
			} else {
				cur2.right = null;
			}
		} else {
			System.out.print(cur1.value + " ");
		}
		cur1 = cur1.right;
	}
}
