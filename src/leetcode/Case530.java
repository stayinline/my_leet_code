package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Case530 {

    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return ret;

    }

    public int ret = Integer.MAX_VALUE;
    public TreeNode prev;

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.left);

        if (prev != null) {
            ret = Math.min(ret, root.val - prev.val);
        }
        prev = root;
        helper(root.right);

    }

    public int getMinimumDifference2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        Collections.sort(list);
        int ret = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            ret = Math.min(list.get(i) - list.get(i - 1), ret);
        }
        return ret;
    }

    public void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
    }

    public static void main(String[] args) {
        Case530 c = new Case530();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(c.getMinimumDifference(root)); // 1
    }
}
