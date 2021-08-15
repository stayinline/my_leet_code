package leetcode;

import java.util.Arrays;
import java.util.Spliterator;

public class Case124 {

    private int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        outOrderHelper(root);
        return sum;
    }

    public int outOrderHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 和0比较，是为了舍弃负数，如果当前结点左右孩子贡献值为负数，那么舍弃即可
        int leftSum = Math.max(0, outOrderHelper(root.left));
        int rightSum = Math.max(0, outOrderHelper(root.right));

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        sum = Math.max(leftSum + rightSum + root.val, sum);

        // 当前结点的最大贡献值=左右孩子中较大的贡献值+当前结点贡献值
        return root.val + Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 3, 2, 5, 6, 6, 3, 3, 3};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));


        int i = Arrays.binarySearch(arr, 4);

        System.out.println(i);

        Spliterator.OfInt spliterator = Arrays.spliterator(arr);
        spliterator.

        System.out.println(spliterator);
    }
}
