package leetcode;

import utils.ListNodeUtil;

public class Case61 {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        int length = Length(head);
        k = k % length;
        if (k == 0) {
            return head;
        }

        ListNode right = Kth(head, k);
        ListNode cur = right;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        return right;
    }

    public static ListNode Kth(ListNode head, int k) {
        ListNode fast = head, slow = head;
        ListNode dumy = new ListNode(-1, head);
        ListNode pre = dumy;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            pre = pre.next;
        }
        pre.next = null;
        return slow;
    }

    public static int Length(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        return len;
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
        ListNodeUtil.printList(node1);

        ListNode head = rotateRight(node1, 10);
        ListNodeUtil.printList(head);
    }
}
