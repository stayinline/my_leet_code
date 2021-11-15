package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Case91 {
    public static int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int pre = 1, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            int tmp = cur;
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    cur = pre;
                } else {
                    return 0;
                }
            } else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6')) {
                cur = cur + pre;
            }
            pre = tmp;
        }
        return cur;
    }

    public static Map<Character, Integer> getMap() {
        Map<Character, Integer> map = new HashMap<>();
        char c = 'A';
        int b = 1;
        for (int i = 0; i < 26; i++) {
            map.put(c, b);
            c++;
            b++;
        }
        return map;
    }


    public static void main(String[] args) {
        System.out.println(getMap());
    }
}
