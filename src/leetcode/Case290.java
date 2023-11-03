package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Case290 {


    /**
     * 核心思路：put()方法在插入新的键值对时会返回该键原来对应的值（如果存在的话），如果不存在则返回null。
     */
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            Integer idx1 = map1.put(pattern.charAt(i), i);
            Integer idx2 = map2.put(words[i], i);
            // idx1、idx2可能为null，所以用Objects.equals判断
            if (!Objects.equals(idx1, idx2)) {
                return false;
            }
        }
        return true;
    }


    // 只比较最后一个和第一个有局限性
    // 如："qqqq","cat dog dog cat" 会输出true，但是错误
    public static boolean wordPatternError(String pattern, String s) {

        String[] arr = s.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            int i1 = pattern.indexOf(c);
            int i2 = pattern.lastIndexOf(c);
            if (!arr[i1].equals(arr[i2])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "a",
                s = "a";

        System.out.println(wordPattern(pattern, s));
    }
}
