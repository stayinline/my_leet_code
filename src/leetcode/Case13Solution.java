package leetcode;

/**
 * @author hemaoling
 */
public class Case13Solution {

    /**
     * 错误在于         ans += first;这一步是弥补循环的最后一个元素，而不是第一个元素
     */
    public int romanToIntError(String s) {
        int ans = 0;
        int first = getValue(s.charAt(0));
        ans += first;
        for (int i = 1; i < s.length(); i++) {
            int second = getValue(s.charAt(i));
            if (first < second) {
                ans -= first;
            } else {
                ans += first;
            }
            first = second;
        }
        return ans;
    }

    public int romanToInt(String s) {
        int sum = 0;
        int firstNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int nextNum = getValue(s.charAt(i));
            if (nextNum > firstNum) {
                sum -= firstNum;
            } else {
                sum += firstNum;
            }
            firstNum = nextNum;
        }
        sum += firstNum;
        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        String s = "III";
        System.out.println(new Case13Solution().romanToInt(s));

        String s2 = "LVIII";
        System.out.println(new Case13Solution().romanToInt(s2));
        System.out.println(new Case13Solution().romanToIntError(s2));

    }
}
