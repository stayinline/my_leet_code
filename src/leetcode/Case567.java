package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Case567 {

    public static boolean checkInclusion(String t, String s) {
        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // 初始化needMap
        for (int i = 0; i < t.length(); i++) {
            needMap.put(t.charAt(i), needMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            Character c = s.charAt(right);
            right++;

            //处理窗口中的数据
            if (needMap.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(needMap.get(c))) {
                    valid++;
                }
            }

            // 判断窗口是否需要收缩
            while (right - left >= t.length()) {
                if (valid == needMap.size()) {
                    return true;
                }
                Character d = s.charAt(left);
                left++;
                if (needMap.containsKey(d)) {
                    if (window.get(d).equals(needMap.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(checkInclusion("ab", "eidbaooo"));

        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            //校验need和window是否符合具体的需要
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (right - left >= t.length()) {
                if (valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;

                if (need.containsKey(c)) {
                    window.put(d, window.getOrDefault(d, 0) - 1);
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                }
            }
        }
        return res;
    }
}
