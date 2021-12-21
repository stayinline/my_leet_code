package offer;

import leetcode.TreeNode;

import java.util.*;

public class Case32_3 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean goLeft = true;

        while (!queue.isEmpty()) {
            Deque<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (goLeft) {
                    list.offerFirst(cur.val);
                } else {
                    list.offerLast(cur.val);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(new ArrayList<>(list));
            goLeft = !goLeft;
        }
        return res;

    }
}
