package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Case76 {


    // t字符串中每个字符出现的次数
    static Map<Character, Integer> tMap = new HashMap<>();
    // 滑动窗口中每个字符及其出现次数
    static Map<Character, Integer> windowMap = new HashMap<>();


    public static String minWindow(String s, String t) {
        // 边界值判断
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        int tLen = t.length();
        int sLen = s.length();

        //将t全部存入map
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        //定义滑动窗口的左右指针
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        for (int l = 0, r = 0; r < sLen; r++) {
            if (tMap.containsKey(s.charAt(r))) {
                windowMap.put(s.charAt(r), windowMap.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check()) {
                //满足条件则尝试缩小滑动窗口的左指针
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (tMap.containsKey(s.charAt(l))) {
                    windowMap.put(s.charAt(l), windowMap.get(s.charAt(l)) - 1);
                }
                l++;
            }
            // 当前滑动窗口不满足之后继续循环，窗口右移
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    // 判断 windowMap 是否包含全部的 tMap
    public static boolean check() {
        Iterator iter = tMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (windowMap.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //System.out.println("abcd".substring(1, 2));

        String s = "a";
        String t = "a";
        System.out.println(minWindow(s, t));
    }

}
