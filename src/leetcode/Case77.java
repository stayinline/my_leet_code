package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Case77 {

    private static List<List<Integer>> result;

    public static List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    backtrack(track, k, n, 1);
        return result;
}


    private static void backtrack(LinkedList<Integer> track, int k, int n, int start) {
        if (track.size() == k) {
            result.add(new ArrayList<>(track));
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(track, k, n, i + 1);
            track.removeLast();
        }
    }


    /**
     * 这样改了每一层的可选元素之后，!track.contains(i) 一定是true，因为每次都是选择下一个元素，
     * 所以也可以去掉
     */
    private static void backtrack1(LinkedList<Integer> track, int k, int n, int start) {
        if (track.size() == k) {
            result.add(new ArrayList<>(track));
        }
        for (int i = start; i <= n; i++) {
            if (!track.contains(i)) {
                track.add(i);
                backtrack1(track, k, n, i + 1);
                track.removeLast();
            }
        }
    }

    /**
     * 这种实现方式中[1,2]和[2,1]是重复的，只保留一个;
     * 问题出在可选择列表中的元素，当前选择了以后，进入决策树的写一个节点，没有排除当前已选择元素
     */
    private static void backtrackError(LinkedList<Integer> track, int k, int n) {
        if (track.size() == k) {
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!track.contains(i)) {
                track.add(i);
                backtrackError(track, k, n);
                track.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

}
