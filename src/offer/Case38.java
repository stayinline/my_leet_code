package offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hemaoling
 */
public class Case38 {
//
//    static List<List<Character>> res = new LinkedList<>();
//
//    public static String[] permutation(String s) {
//        // 记录「路径」
//        LinkedList<Character> track = new LinkedList<>();
//        backtrack(s.toCharArray(), track);
//        String[] arr = new String[res.size()];
//        for (int i = 0; i < res.size(); i++) {
//            List<Character> list = res.get(i);
//            StringBuilder sb = new StringBuilder();
//            for (Character c : list) {
//                sb.append(c);
//            }
//            arr[i] = sb.toString();
//        }
//        return arr;
//    }
//
//    static void backtrack(char[] nums, LinkedList<Character> track) {
//        // 触发结束条件
//        if (track.size() == nums.length) {
//            res.add(new LinkedList(track));
//            return;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            // 排除不合法的选择
//            if (track.contains(nums[i]))
//                continue;
//            // 做选择
//            track.add(nums[i]);
//            // 进入下一层决策树
//            backtrack(nums, track);
//            // 取消选择
//            track.removeLast();
//        }
//    }
//

    /*****************下为官方解法**************************/


    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    void dfs(int x) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c));      // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x);                      // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1);                   // 开启固定第 x + 1 位字符
            swap(i, x);                      // 恢复交换
        }
    }

    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Case38().permutation("aab")));
    }

}
