package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 */
public class Case155 {

    // error
//    public static class MinStack1 {
//
//        private List<Integer> min;
//
//        //逆序的
//        private List<Integer> minStack;
//
//        public MinStack1() {
//            min = new ArrayList<>();
//            minStack = new ArrayList<>();
//        }
//
//        public void push(int val) {
//            min.add(val);
//            if (!minStack.isEmpty()) {
//                if (minStack.get(minStack.size() - 1) > val) {
//                    minStack.add(val);
//                } else {
//                    minStack.add(minStack.get(minStack.size() - 1));
//                }
//            } else {
//                minStack.add(val);
//            }
//        }
//
//        public void pop() {
//            min.remove(min.size() - 1);
//            if (!minStack.isEmpty() && minStack.get(0).equals(min.get(min.size() - 1))) {
//                minStack.remove(0);
//            }
//
//        }
//
//        public int top() {
//            return min.get(0);
//        }
//
//        public int getMin() {
//            return minStack.isEmpty() ? 0 : minStack.get(minStack.size() - 1);
//        }
//    }


    class MinStack {
        Deque<Integer> xStack;
        Deque<Integer> minStack;

        public MinStack() {
            xStack = new LinkedList<>();
            minStack = new LinkedList<>();

            // 这里面先房一个最大元素，这样就不用判空处理，很方便！
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            xStack.push(x);
            minStack.push(Math.min(minStack.peek(), x));
        }

        public void pop() {
            xStack.pop();
            minStack.pop();
        }

        public int top() {
            return xStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        Deque<Integer> minStack =new LinkedList<>();
        minStack.push(1);
        minStack.push(10);
        minStack.push(29);
        minStack.push(21);

        System.out.println(minStack);

        System.out.println(minStack.peek());
    }

}
