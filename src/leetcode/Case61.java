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

        ListNode kHead = Kth(head, k);
        ListNode cur = kHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        return kHead;
    }

    public static ListNode rotateRight1(ListNode head, int k) {

        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        int len = Length(head);
        k = k % len;

        if (k == 0) {
            return head;
        }
        ListNode l = head, r = head;
        while (k > 0) {
            r = r.next;
            k--;
        }

        while (r.next != null) {
            l = l.next;
            r = r.next;
        }
        // 这么直接写的话：1，2，3，4，5，之后的3依然连接着4,
        // 虽然返回了4作为头结点，但是会形成环
//        ListNode newHead = new ListNode(-1);
//        newHead.next = l.next;
//        r.next = head;


        ListNode kHead = l.next;

        l.next = null;

        r.next = head;


        return kHead;

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
        // 这一步操作非常重要，断开了链表的环
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
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        ListNodeUtil.printList(node1);

//        ListNode head = rotateRight1(node1, 2);
        ListNode head = rotateRight1(node1, 2);
        ListNodeUtil.printList(head);
    }
}
