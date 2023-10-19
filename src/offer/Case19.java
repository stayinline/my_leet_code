package offer;

import leetcode.ListNode;
import utils.ListNodeUtil;

public class Case19 {


    public static ListNode removeNthFromEndError(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode r = head, l = head;
        ListNode ahead = new ListNode(-1);
        ahead.next = head;
        ListNode pre = ahead;
        for (int i = 0; i < n - 1; i++) {
            r = r.next;
        }

        while (r.next != null) {
            l = l.next;
            r = r.next;
            pre = pre.next;
        }

        // 这种解法的问题在于：head的关联关系没处理，最后返回值是不正确的
        pre.next = l.next;

        ahead.next = null;
        l.next = null;
        return head;

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }

        ListNode ahead = new ListNode(-1);
        ahead.next = head;

        ListNode fast = head;
        ListNode slow = ahead;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //不会发生空指针的原因在于：slow是从ahead开始，slow.next就是head，slow.next.next 这个结果才有可能为null
        slow.next = slow.next.next;
        return ahead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode head = removeNthFromEnd(node1, 1);
        ListNodeUtil.printList(head);
    }
}
