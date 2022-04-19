package offer;

import leetcode.ListNode;

public class Case52 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //首先获取两个链表的长度
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        ListNode curA = headA, curB = headB;
        //对齐两个指针，谁长谁向后走一个
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

        //向后齐步走，直到相遇
        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }

    /**
     * 获取长度
     *
     * @param head
     * @return
     */
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
