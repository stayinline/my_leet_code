package offer;

import leetcode.ListNode;

public class Case22 {

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cur = head, prev = head;
        while (k > 0) {
            cur = cur.next;
            k--;
        }
        while (cur != null) {
            cur = cur.next;
            prev = prev.next;
        }
        return prev;
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
        ListNode kth = getKthFromEnd(node1, 2);
        System.out.println(kth.val);
    }
}
