package offer;

import java.util.Stack;

public class Case31 {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] in = {1, 2, 3, 4, 5};
        int[] out = {4, 5, 3, 2, 1};
        System.out.println(validateStackSequences(in, out));
    }
}
