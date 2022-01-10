package offer;

import leetcode.TreeNode;

public class Case55 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(helper(root.left) - helper(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        return Math.max(left, right) + 1;
    }

}
