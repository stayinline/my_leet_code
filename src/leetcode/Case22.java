package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Case22 {


    private static List<String> result;


    public static List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        StringBuilder track = new StringBuilder();
        String[] arr = {"(", ")"};
        backtrack(track, arr, n);
        return result;
    }


    private static void backtrack(StringBuilder track, String[] arr, int n) {
        System.out.println(track + "-->" + isValid(track.toString()));
        if (track.length() > 2 * n) {
            return;
        }
        if (track.length() == (2 * n) && isValid(track.toString())) {
            result.add(track.toString());
        } else {
            for (String s : arr) {
                track.append(s);
                backtrack(track, arr, n);
                track.deleteCharAt(track.length() - 1);
            }
        }
    }

    public static boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count == 0) {
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
        System.out.println(isValid("()())("));
    }

}
