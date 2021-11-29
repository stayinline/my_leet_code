package offer;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Case34 {

    class Solution {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        int targetG;

        public List<List<Integer>> pathSum(TreeNode root, int target) {
            targetG = target;
            preOrder(root);
            return ret;
        }

        public void preOrder(TreeNode root) {
            if (root == null) {
                return;
            }

            path.add(root.val);

            if (root.left == null && root.right == null) {
                int sum = 0;
                for (Integer val : path) {
                    sum += val;
                }
                if (sum == targetG) {
                    ret.add(new ArrayList<>(path));
                }
            }

            preOrder(root.left);
            preOrder(root.right);

            path.remove(path.size() - 1);

        }

    }

    public static void main(String[] args) {

        System.out.println( (double) (2+1)/2);
    }



}
