package offer2;

import leetcode.ListNode;


/**
 * 给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class Case21 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        ListNode dumy = new ListNode(0);
        dumy.next = head;

        ListNode fast = head, slow = head, pre = dumy;
        while (n > 0) {
            fast = fast.next;
            n--;
        }

        while (fast != null) {
            fast = fast.next;
            pre = pre.next;
            slow = slow.next;
        }
        pre.next = slow == null ? null : slow.next;
        return dumy.next;
    }
}
