package offer;

import leetcode.ListNode;


public class Case18 {
    public static ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }

        ListNode cur = head, prev = head;
        int count = 0;
        while (cur.val != val) {
            cur = cur.next;
            count++;
        }
        while (count > 1) {
            prev = prev.next;
            count--;
        }

        prev.next = cur.next;
        return head;
    }



    public static void main(String[] args) {
        ListNode node1 = new ListNode(-3);
        ListNode node2 = new ListNode(-5);
        ListNode node3 = new ListNode(-99);
        node1.next = node2;
        node2.next = node3;
        ListNode head = deleteNode(node1, -3);
        ListUtils.printList(head);
    }

}
