package leetcode;

import java.util.Stack;

public class Case20 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (isRight(c) && !stack.isEmpty()) {
                if (stack.peek() == getTheOther(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static boolean isRight(Character c) {
        return '}' == c || ')' == c || ']' == c;
    }

    public static Character getTheOther(Character c) {
        if (')' == c) {
            return '(';
        } else if ('}' == c) {
            return '{';
        } else {
            return '[';
        }
    }

    public static void main(String[] args) {

        System.out.println(isValid("(])"));

    }
}
