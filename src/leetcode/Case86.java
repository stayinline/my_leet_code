package leetcode;


import java.util.ArrayList;
import java.util.List;

public class Case86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (cur.val < x) {
                list1.add(cur.val);
            } else {
                list2.add(cur.val);
            }
        }
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        if (!list1.isEmpty()) {
            for (Integer val : list1) {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
        }
        if (!list2.isEmpty()) {
            for (Integer val : list2) {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
        }
        return pre.next;
    }
}
