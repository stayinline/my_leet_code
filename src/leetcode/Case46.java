package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Case46 {


    static List<List<Integer>> res = new ArrayList<>();


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums, track);
        return res;
    }

    private static void backTrack(int[] nums, LinkedList<Integer> track) {
        //这里当数组长度和路径track的长度相等时，退出递归
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int num : nums) {
            //判断路径是否包含当前元素，包含说明已经采用过了，不包含时则可以采用
            if (track.contains(num)) {
                continue;
            }

            track.add(num);

            //递归从头开始寻找可选队列中的元素
            backTrack(nums, track);

            //出递归的时候，一定是上一层中已经选取过当前元素，所以退回到上一层的时候需要把决策树的最后一层去掉
            track.removeLast();
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> permute = permute(arr);
        System.out.println(permute);
    }
}
