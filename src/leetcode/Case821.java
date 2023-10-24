package leetcode;

import java.util.Arrays;

public class Case821 {

    public static int[] shortestToChar(String s, char c) {

        int len = s.length();
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            int left = Integer.MAX_VALUE;
            int right = Integer.MAX_VALUE;
            int l = i, r = i;
            while (l >= 0) {
                if (c == s.charAt(l)) {
                    left = Math.abs(l - i);
                    break;
                }
                l--;
            }
            while (r < len) {
                if (c == s.charAt(r)) {
                    right = Math.abs(r - i);
                    break;

                }
                r++;
            }
            answer[i] = Math.min(left, right);
        }
        return answer;

    }

    public static void main(String[] args) {
        String s = "baaa";
        System.out.println(Arrays.toString(shortestToChar(s, 'b')));
    }
}
