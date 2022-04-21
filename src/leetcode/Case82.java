package leetcode;

import utils.ListNodeUtil;

public class Case82 {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy;
        // 注意：视角是以cur遍历整个链表，所以cur = dummy；
        // 主要判断的是cur的后两个节点的val是否相等
        while (cur.next != null && cur.next.next != null) {
            // cur的后两个节点相等，说明重复出现了，直接逐个链接下一个节点
            ListNode nxt = cur.next;
            if (nxt.val == nxt.next.val) {
                int x = nxt.val;
                while (nxt != null && nxt.val == x) {
                    cur.next = nxt.next;
                    nxt = nxt.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNodeUtil.printList(deleteDuplicates(node1));
    }


}
