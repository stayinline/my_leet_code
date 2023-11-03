package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Case49 {


    // 简化groupAnagrams1中的countMap逻辑
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] charArray = new char[26];
            for (char c : s.toCharArray()) {
                charArray[c - 'a']++;
            }
            String key = String.valueOf(charArray);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    //
    public static List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            //以每个字符串中每个字母出现的次数的map作为键
            Map<Character, Integer> countMap = getCountMap(strs[i]);
            List<String> list = map.getOrDefault(countMap, new ArrayList<>());
            list.add(strs[i]);
            map.put(countMap, list);
        }

        for (Map<Character, Integer> key : map.keySet()) {
            List<String> list = map.get(key);
            ans.add(list);
        }
        return new ArrayList<>(map.values());
    }


    public static List<List<String>> groupAnagramsError2(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            int[] c1 = getCount(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                int[] c2 = getCount(strs[j]);
                if (equals(c1, c2)) {
                    List<String> list = new ArrayList<>();
                    list.add(strs[i]);
                    list.add(strs[j]);
                    ans.add(list);
                }

            }
        }
        return ans;
    }

    // 错误之处在没处理重复元素，双重循环的问题
    public static List<List<String>> groupAnagramsError(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            int[] c1 = getCount(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                int[] c2 = getCount(strs[j]);
                if (equals(c1, c2)) {
                    List<String> list = new ArrayList<>();
                    list.add(strs[i]);
                    list.add(strs[j]);
                    ans.add(list);
                }

            }
        }
        return ans;
    }

    public static int[] getCount(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        return count;
    }

    public static boolean equals(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static Map<Character, Integer> getCountMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
