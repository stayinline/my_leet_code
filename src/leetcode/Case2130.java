package leetcode;

public class Case2130 {

    public static int pairSum(ListNode head) {
        if (head == null) return 0;

        ListNode fast = head;
        ListNode slow = head;
        // 1. 用快慢指针寻找链表中点，slow指向中间
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 2. 反转后slow以后的半部分链表，mid为反转后的头结点
        ListNode cur = slow;
        ListNode mid = null;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = mid;
            mid = cur;
            cur = nxt;
        }

        // 3. 计算孪生和，分别从head和mid开始遍历
        int maxTwinSum = 0;
        while (head != null && mid != null) {
            maxTwinSum = Math.max(maxTwinSum, head.val + mid.val);
            head = head.next;
            mid = mid.next;
        }
        return maxTwinSum;
    }
}
