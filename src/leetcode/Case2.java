package leetcode;

import utils.ListNodeUtil;

public class Case2 {

    // 简化代码
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(-1);
        ListNode i = l1, j = l2, p = prev;
        int flag = 0;
        while (i != null || j != null) {
            int x = i == null ? 0 : i.val;
            int y = j == null ? 0 : j.val;
            int sum = x + y + flag;
            int val = sum % 10;
            flag = sum / 10;

            p.next = new ListNode(val);
            p = p.next;

            i = i == null ? null : i.next;
            j = j == null ? null : j.next;
        }
        if (flag == 1) {
            p.next = new ListNode(flag);
        }
        return prev.next;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(-1, null);
        ListNode i = l1, j = l2, p = prev;

        int flag = 0;
        while (i != null && j != null) {
            int sum = i.val + j.val + flag;
            int val = sum % 10;
            flag = sum / 10;
            ListNode cur = new ListNode(val, null);
            p.next = cur;
            p = p.next;
            i = i.next;
            j = j.next;
        }
        while (i != null) {
            int sum = i.val + flag;
            int val = sum % 10;
            flag = sum / 10;
            p.next = new ListNode(val, null);
            p = p.next;
            i = i.next;
        }
        while (j != null) {
            int sum = j.val + flag;
            int val = sum % 10;
            flag = sum / 10;
            p.next = new ListNode(val, null);
            p = p.next;
            j = j.next;
        }
        if (flag == 1) {
            p.next = new ListNode(flag, null);
        }
        return prev.next;
//        return reverse(prev.next);
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(4, node3);
        ListNode node1 = new ListNode(2, node2);

        ListNode node6 = new ListNode(4);
        ListNode node5 = new ListNode(6, node6);
        ListNode node4 = new ListNode(5, node5);
        ListNode head = addTwoNumbers(node1, node4);
        ListNodeUtil.printList(head);
    }

}
