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
        backtrack(track, candidates, target);
        return result;
    }


    private static void backtrack(LinkedList<Integer> track, int[] candidates, int target) {
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
            for (int candidate : candidates) {
                track.add(candidate);
                backtrack(track, candidates, target);
                track.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        System.out.println(combinationSum(candidates, 7));
    }

}
