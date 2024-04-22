package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Case151 {
    public String reverseWords1(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public static String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        s = s.trim();
        int i = 0, j = 0;
        int len = s.length();
        while (i < len) {
            while (i < len && (s.charAt(i) == ' ' || Character.isDigit(s.charAt(i)))) {
                i++;
            }
            j = i;
            while (j < len && s.charAt(j) != ' ' && !Character.isDigit(s.charAt(j))) {
                j++;
            }
            list.add(s.substring(i, j));
            i = j;
        }
        Collections.reverse(list);
        return String.join(" ", list);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords(" world hello"));
    }
}
