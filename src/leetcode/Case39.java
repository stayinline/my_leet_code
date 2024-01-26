package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Case39 {

    private static List<List<Integer>> result;

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(track, candidates, target, 0, candidates.length);
        return result;
    }


    private static void backtrack(LinkedList<Integer> track, int[] candidates, int target, int start, int end) {
        int sum = 0;
        for (Integer i : track) {
            sum += i;
        }
        if (target < sum) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(track));
        } else {
            for (int i = start; i < end; i++) {
                track.add(candidates[i]);
                backtrack(track, candidates, target, i, end);
                track.removeLast();
            }
        }
    }

    private static void backtrackError(LinkedList<Integer> track, int[] candidates, int target) {
        int sum = 0;
        for (Integer i : track) {
            sum += i;
        }
        if (target < sum) {
            return;
        }
        if (sum == target) {
            if (result.isEmpty()) {
                result.add(new ArrayList<>(track));
            } else {
                // 这里错误的原因是main方法中的示例，containsAll 方法判断不适用于当前场景
                List<List<Integer>> tmp = new ArrayList<>(result);
                for (List<Integer> ret : tmp) {
                    if (!ret.containsAll(track)) {
                        result.add(new ArrayList<>(track));
                    }
                }
            }
        } else {
            for (int candidate : candidates) {
                track.add(candidate);
                backtrackError(track, candidates, target);
                track.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        System.out.println(combinationSum(candidates, 8));

        List<Integer> tmp = new ArrayList<>();
        tmp.add(2);
        tmp.add(2);
        tmp.add(2);
        tmp.add(2);


        List<Integer> tmp2 = new ArrayList<>();
        tmp2.add(2);
        tmp2.add(3);
        tmp2.add(3);

        System.out.println(tmp.containsAll(tmp2));// false
        System.out.println(tmp2.containsAll(tmp));// true,只要出现过一次就行


    }

}
