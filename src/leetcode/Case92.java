package leetcode;

import utils.ListNodeUtil;

public class Case92 {


    /**
     * 头插法，逐个逆置[left,right]区间的每个元素
     * 1 ->  3 ->  2 ->  4 ->  5
     * 1 ->  4 ->  3 ->  2 ->  5
     * 1 ->  4 ->  3 ->  2 ->  5
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode tmp = new ListNode(0, head);
        ListNode l = head;  // 找到left对应的节点
        ListNode pre = tmp; // 找到left的前一个
        for (int i = 0; i < left - 1; i++) {
            l = l.next;
            pre = pre.next;
        }

        for (int i = 0; i < right - left; i++) {
            ListNode next = l.next;
            l.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return tmp.next;
    }

    /**
     * 下面是代码中出现的错误的分析；
     * <p>
     * 你没有使用哑结点，这样在反转部分链表时如果遇到left == 1时会出现问题。
     * 反转链表的部分也有问题，你应该反转left到right位置的链表，而不是到r位置的链表，因为r不一定是right位置。
     * 你的代码假定left和right总是有效的，但如果left比链表的长度大或right比链表的长度小，则代码会出错。
     */
    public static ListNode reverseBetweenError2(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }
        int i = left;
        ListNode lp = head;
        while (i > 2) {
            i--;
            lp = lp.next;
        }
        ListNode l = head;
        while (left > 1) {
            left--;
            l = l.next;
        }

        int j = right;
        ListNode rn = head;
        while (j > 0) {
            j--;
            rn = rn.next;
        }
        ListNode r = head;
        while (right > 1) {
            right--;
            r = r.next;
        }
        lp.next = null;
        r.next = null;

        ListNode newHead = reverse(l, r);
        lp.next = newHead;

        l.next = rn;
        return head;
    }

    /**
     * 错误的解法：理解错了题意，[left.right]表示的是位置下标，而不是链表节点的元素值！！！
     */
    public static ListNode reverseBetweenError(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }
        ListNode i = head;
        while (i.next != null && i.next.val != left) {
            i = i.next;
        }

        ListNode j = i;
        while (j != null && j.val != right) {
            j = j.next;
        }
        if (null == j) {
            return head;
        }

        ListNode L = i.next;
        i.next = null;

        ListNode R = j;
        ListNode rNext = j.next;
        j.next = null;
        ListNode newHead = reverse(L, R);
        i.next = newHead;
        ListNode k = newHead;
        while (k.next != null) {
            k = k.next;
        }

        k.next = rNext;
        return head;
    }

    //[l,r] 闭区间
    public static ListNode reverse(ListNode l, ListNode r) {
        ListNode pre = null, cur = l;
        while (cur != r) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        cur.next = null;
        r.next = pre;
        return r;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

//        ListNodeUtil.printList(reverse(node2, node4));

        ListNodeUtil.printList(node3);

        ListNodeUtil.printList(reverseBetween(node1, 2, 4));
//        ListNodeUtil.printList(reverseBetween(node3, 1, 2));
    }
}
