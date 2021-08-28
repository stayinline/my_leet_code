package leetcode;

public class Case50 {
    public static char firstUniqChar(String s) {
        int index = Integer.MAX_VALUE;
        char ans = ' ';

        //选择枚举a-z字母表，而不是枚举字符串s，字母表的枚举等同于是常数级遍历
        for (char c = 'a'; c <= 'z'; c++) {
            int firstIdx = s.indexOf(c);

            // first index,如果在s内，且等于lastIndex，只出现一次
            if (firstIdx != -1 && firstIdx == s.lastIndexOf(c)) {
                // 判断索引是否是最小的，把每次比较最小的赋给ans，即第一个不重复的值
                if (index > firstIdx) {
                    index = firstIdx;
                    ans = c;
                }
            }
        }
        return ans;
    }

}
