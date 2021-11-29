package offer;

import leetcode.TreeNode;

public class Case54 {

    class Solution {
        int kG, ret;

        public int kthLargest(TreeNode root, int k) {
            kG = k;
            inOrder(root);
            return ret;
        }

        public void inOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrder(root.right);
            kG--;
            if (kG == 0) {
                ret = root.val;
            }
            inOrder(root.left);

        }
    }
}
