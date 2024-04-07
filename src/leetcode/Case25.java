package leetcode;

import java.util.List;

import static offer.ListUtils.printList;

public class Case25 {


    public static ListNode reverseKGroup(ListNode head, int k) {
        // 边界条件
        if (null == head || head.next == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        // pre记录每组的上一个节点，end记录每组的右端点
        ListNode pre = dummy, end = dummy;

        while (end.next != null) {
            // end向后移动k-1步，到达翻转区间的右端点
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                // 不足一组的不翻转
                break;
            }

            // start表示每组的头结点，
            ListNode start = pre.next;
            // next表示下一组的头结点
            ListNode next = end.next;

            //断开每组的右端点连接
            end.next = null;

            // 翻转当前组，并连接到pre
            pre.next = reverseList(start);

            // 翻转后，start就是当前组的右端点，连接到下一个区间的头结点
            start.next = next;

            // pre和end重新定位到下一组的头结点
            end = start;
            pre = start;
        }
        return dummy.next;
    }

    public static ListNode reverseList(ListNode start) {
        if (null == start || start.next == null) {
            return start;
        }
        ListNode pre = null, cur = start;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head = reverseKGroup(node1, 3);

        printList(head);
    }

    public static void main(String[] args) {
        test();
    }
}
