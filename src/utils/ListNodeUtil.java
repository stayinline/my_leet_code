package utils;

import leetcode.ListNode;

public class ListNodeUtil {

    public static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ->  ");
            cur = cur.next;
        }
        System.out.println("");
    }
}
