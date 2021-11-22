package offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Case48 {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (dic.containsKey(s.charAt(j))) {
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            }
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }

    public static int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int i = 0, j = 0, count = 0;
        Map<Character, Integer> window = new HashMap<>();
        while (j < s.length()) {
            char c = s.charAt(j);
            j++;
            window.put(c, window.getOrDefault(c, 0) + 1);

            while (window.get(c) > 1) {
                char d = s.charAt(i);
                i++;
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
            count = Math.max(count, j - i);
        }
        return count;
    }


    public static void main(String[] args) {
//        int i = lengthOfLongestSubstring("pwwkew");
//        System.out.println(i);
        int abcabcbb = lengthOfLongestSubstring1("abcabcbb");
        System.out.println(abcabcbb);
    }
}
