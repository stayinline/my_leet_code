package offer;

import leetcode.ListNode;

public class Case22 {

    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k < 0) {
            return null;
        }
        ListNode fast = head, slow = head;
        // 这里的核心是 [slow,fast] 区间的左端点就是目标节点
        // 所以先让fast前进k次，使得区间长度等于k
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        // 最后再让slow和fast一起前进，最终返回区间左端点即可
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode kth = getKthFromEnd(node1, 2);
        System.out.println(kth.val);
    }
}
