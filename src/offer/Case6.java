package offer;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Case6 {


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {

        public int[] reversePrint(ListNode head) {
            Stack<Integer> stack = new Stack();
            while (head != null) {
                stack.push(head.val);
                head = head.next;
            }
            int[] ret = new int[stack.size()];
            int i = 0;
            while (!stack.isEmpty()) {
                ret[i] = stack.pop();
                i++;
            }
            return ret;
        }

        public int[] reversePrint2(ListNode head) {
            ListNode newHead = reverseList(head);
            List<Integer> list = new ArrayList<>();
            while (newHead != null) {
                list.add(newHead.val);
                newHead = newHead.next;
            }
            int[] ret = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ret[i] = list.get(i);
            }
            return ret;
        }

        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
}
