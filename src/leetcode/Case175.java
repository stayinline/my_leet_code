package leetcode;

public class Case175 {


    public int calculateDepth(TreeNode root) {
        return fenzhiHelper(root);
    }

    private int fenzhiHelper(TreeNode curRoot) {
        if (curRoot == null) {
            return 0;
        }
        int left = fenzhiHelper(curRoot.left);
        int right = fenzhiHelper(curRoot.right);
        return Math.max(left, right) + 1;
    }
}
