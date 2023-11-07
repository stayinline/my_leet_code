package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Case3 {
    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0, j = i; j < s.length(); ) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            } else {
                set.add(s.charAt(j));
                ans = Math.max(ans, set.size());
                j++;
            }
        }
        return ans;
    }

    // 官方答案，不好理解
    public static int lengthOfLongestSubstring1(String s) {
        Set<Character> set = new HashSet<>();
        int r = 0;
        int res = 0;
        int len = s.length();
        for (int l = 0; l < len; l++) {
            //这里左指针不为0则说明这个元素是由右指针放入set的，左指针移动之后，应该删除
            if (l != 0) {
                set.remove(s.charAt(l - 1));
            }

            //判断set中是否包含当前字符，不包含就说明不是重复的
            while (r < len && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
            }

            res = Math.max(res, r - l);
        }
        return res;
    }

    public static void main(String[] args) {
        int ret = lengthOfLongestSubstring(" ");
        System.out.println(ret);

    }
}
