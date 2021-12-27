package offer;

import leetcode.ListNode;

public class Case52 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        ListNode curA = headA, curB = headB;
        while (lenA != lenB) {
            if (lenA > lenB) {
                curA = curA.next;
                lenA--;
            }
            if (lenA < lenB) {
                curB = curB.next;
                lenB--;
            }
        }

        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }

    public int getLen(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }


}
