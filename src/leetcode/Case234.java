package leetcode;

import java.util.List;

public class Case234 {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rightHead;
        if (fast == null) {
            rightHead = slow;
        } else {
            rightHead = slow.next;
        }

        rightHead = reverse(rightHead);

        for (ListNode cur1 = head, cur2 = rightHead; cur2 != null; cur1 = cur1.next, cur2 = cur2.next) {
            if (cur1.val != cur2.val) {
                return false;
            }
        }
        return true;
    }


    public ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

}
