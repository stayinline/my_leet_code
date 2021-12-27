package offer;

import leetcode.ListNode;

public class ListUtils {

    public static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println("");
    }
}
