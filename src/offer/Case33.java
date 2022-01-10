package offer;

public class Case33 {

    public static boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    static boolean helper(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int p = start;
        // 左子树的节点都比root小
        while (postorder[p] < postorder[end]) {
            p++;
        }
        int root = p;
        // 右子树的节点都比root大
        while (postorder[p] > postorder[end]) {
            p++;
        }
        // 最终 p==end 说明序列是合法的
        // 然后依次地柜左右子树判断即可
        return p == end
                && helper(postorder, start, root - 1)
                && helper(postorder, root, end - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, 5};
        System.out.println(verifyPostorder(arr));
    }
}
