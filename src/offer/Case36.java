package offer;

import leetcode.Node;

public class Case36 {

    class Solution {
        Node pre, head;

        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            inOrder(root);
            head.left = pre;
            pre.right = head;
            return head;
        }

        void inOrder(Node cur) {
            if (cur == null) {
                return;
            }
            inOrder(cur.left);
            if (pre != null) {
                pre.right = cur;
            } else {
                head = cur;
            }
            cur.left = pre;
            pre = cur;
            inOrder(cur.right);
        }
    }

}
