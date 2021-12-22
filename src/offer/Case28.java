package offer;

import leetcode.TreeNode;

public class Case28 {

    public boolean isSymmetric(TreeNode root) {
        return root == null || helper(root.left, root.right);
    }

    public boolean helper(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l == null || r == null || l.val != r.val) {
            return false;
        }
        return helper(l.left, r.right) && helper(l.right, r.left);
    }
}
