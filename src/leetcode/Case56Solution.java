package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Case56Solution {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) {
            return new int[2][2];
        }
        List<int[]> ans = new ArrayList<>();
        // 按照区间的左端点，将整个数组升序排列
        // 为什么是comparing(x -> x[0])？因为x表示intervals数组的每个元素，是一个int[2][2]的数组，所以x[0]就是左端点
        Arrays.sort(intervals, Comparator.comparing(x -> x[0]));

        for (int[] interval : intervals) {
            int l = interval[0];
            int r = interval[1];
            int lastIdx = ans.size() - 1;
            if (0 == ans.size() || ans.get(lastIdx)[1] < l) {
                ans.add(new int[]{l, r});
            } else {
                ans.get(lastIdx)[1] = Math.max(ans.get(lastIdx)[1], r);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }


    // 用二层list实现
    public static List<List<Integer>> merge2(List<List<Integer>> intervals) {
        if (intervals.size() == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        // 按照区间的左端点，将整个数组升序排列
        intervals.sort(Comparator.comparing(list -> list.get(0)));

        for (List<Integer> interval : intervals) {
            int l = interval.get(0);
            int r = interval.get(1);
            if (ans.isEmpty() || ans.get(ans.size() - 1).get(1) < l) {
                ans.add(Arrays.asList(l, r));
            } else {
                ans.get(ans.size() - 1).set(1, Math.max(ans.get(ans.size() - 1).get(1), r));
            }
        }
        return ans;
    }


    public static int[][] merge1(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        //按照区间的左端点排序
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; ++i) {
            //取出每个区间的左右端点
            int L = intervals[i][0], R = intervals[i][1];
            if (res.size() == 0 || res.get(res.size() - 1)[1] < L) {
                //res中最后一个区间的右端点比当前左区间还小，说明两个区间存在断档，应该新增进去
                res.add(new int[]{L, R});
            } else {
                //res中最后一个区间的右端点>=当前左区间,说明有重叠，应该更新res中最后一个区间的右端点，以扩大区间长度
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], R);
                //注意这种写法，List中存的是数组，res.get(res.size() - 1)取出的是一个数组，再跟【1】取到右端点
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.toString(intervals[0]));
//        int[][] merge = merge(intervals);
        int[][] merge = merge(intervals);
//        System.out.println(merge);

        System.out.println(Arrays.deepToString(merge));

    }
}
