package offer;

import leetcode.TreeNode;

public class Case26 {
    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) {
                return false;
            }
            return compareAB(A, B)/*判断以A、B两个节点为根的树是否相同*/
                    || isSubStructure(A.left, B)/*如果不是，那么递归的校验A节点的所有子节点，先从左子树*/
                    || isSubStructure(A.right, B);/*如果左子树不是，那么递归的校验A节点的右子树*/
        }

        //递归比较以A、B两个节点为根的树是否相同
        boolean compareAB(TreeNode A, TreeNode B) {
            if (B == null) {
                return true;
            }
            if (A == null || A.val != B.val) {
                return false;
            }
            return compareAB(A.left, B.left) && compareAB(A.right, B.right);
        }
    }

}
