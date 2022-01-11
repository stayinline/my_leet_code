package offer;

import java.util.Stack;

public class Case30 {

    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
            stack.push(x);
        }

        public void pop() {
            if (stack.isEmpty()) {
                return;
            }
            if (stack.pop() <= minStack.peek()) {
                minStack.pop();
            }
        }

        public int top() {
            if (stack.isEmpty()) {
                return 0;
            }
            return stack.peek();
        }

        public int min() {
            if (minStack.isEmpty()) {
                return 0;
            }
            return minStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
}
