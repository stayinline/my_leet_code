package leetcode;

import offer.ListUtils;

public class Case1721 {
    /**
     * 交换两个节点的值
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode swapNodes(ListNode head, int k) {
        ListNode left = head;// 第k个节点
        ListNode right = head;// 倒数第k个节点
        for (int i = 1; i < k; i++) {
            left = left.next;
        }
        ListNode cur = left;
        while (cur.next != null) {
            right = right.next;
            cur = cur.next;
        }
        // 交换左右两个节点的值
        int m = right.val;
        right.val = left.val;
        left.val = m;
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        swapNodes(node1, 2);
        ListUtils.printList(node1);
    }
}
