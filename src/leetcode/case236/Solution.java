package leetcode.case236;


import leetcode.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中
 *
 * @author hemaoling
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case递归出口
        if (/**1*/null == root ||/**2*/p == root ||/**3*/q == root) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        /**第一：后序遍历等同于自下往上，所以应该用后序遍历框架
         *第二：后序递归结果中，根据base case的返回值，只能有三种情况
         */
        //a.如果p和q都在以root为根的树中，也就是base case 2或3返回的，那么left和right一定分别是p或q
        if (left != null && right != null) {
            return root;
        }

        //b.如果p和q都不在以root为根的树中，直接返回null
        if (left == null && right == null) {
            return null;
        }

        //c.如果p和q只有一个存在于root为根的树中，返回该节点
        return right == null ? left : right;
    }

    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();

    public void helper(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            helper(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            helper(root.right);
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        helper(root);
        // 顺着p向上找
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }

        // 顺着q向上找，如果p的parent中找到了q，说明p和q的最近公共祖先就是q
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }


}
