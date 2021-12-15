package offer;

import java.util.*;

public class Case59_2 {

    class MaxQueue {
        Queue<Integer> q;
        Deque<Integer> d; // 存储每一个元素插入时候，当前所有元素的最大值

        public MaxQueue() {
            q = new LinkedList<>();
            d = new LinkedList<>();
        }

        public int max_value() {
            if (d.isEmpty()) {
                return -1;
            }
            return d.peekFirst();
        }

        public void push_back(int value) {
            // 把比value小的元素全都移除，保证单调队列中存储的一直都是当前所有元素的最大值
            while (!d.isEmpty() && d.peekLast() < value) {
                d.pollLast();
            }
            d.offerLast(value);
            q.offer(value);
        }

        public int pop_front() {
            if (q.isEmpty()) {
                return -1;
            }
            int ans = q.poll();
            if (ans == d.peekFirst()) {
                d.pollFirst();
            }
            return ans;
        }
    }


    /**
     * 暴力法
     */
    class MaxQueue2 {
        int[] q = new int[20000];
        int begin = 0, end = 0;

        public MaxQueue2() {

        }

        public int max_value() {
            int ans = -1;
            for (int i = begin; i != end; ++i) {
                ans = Math.max(ans, q[i]);
            }
            return ans;
        }

        public void push_back(int value) {
            q[end++] = value;
        }

        public int pop_front() {
            if (begin == end) {
                return -1;
            }
            return q[begin++];
        }
    }


}
