package leetcode;


/**
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 *
 * @author hemaoling
 */
public class Case1448 {

    private int count = 0;

    public int goodNodes(TreeNode root) {
        preOrderHelper(root, root.val);
        return count;
    }

    private void preOrderHelper2(TreeNode cur, int preVal) {
        if (cur == null) {
            return;
        }
        if (preVal <= cur.val) {
            count++;
        }
        preOrderHelper2(cur.left, cur.val);
        preOrderHelper2(cur.right, cur.val);
    }

    private void preOrderHelper(TreeNode cur, int curMax) {
        if (cur == null) {
            return;
        }
        if (curMax <= cur.val) {
            count++;
            curMax = cur.val;
        }
        preOrderHelper(cur.left, curMax);
        preOrderHelper(cur.right, curMax);
    }
}
