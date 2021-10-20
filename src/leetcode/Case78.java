package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Case78 {

    List<Integer> list = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    /**
     * 循环法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        subsetsHelper2(nums, list, 0);
        return ans;
    }

    public void subsetsHelper2(int[] nums, List<Integer> list, int start) {
        ans.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            subsetsHelper2(nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }


    /**
     * 递归法
     *
     * @param nums
     * @return
     */

    public static List<List<Integer>> subsetsDigui(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        subsetsHelper(nums, list, 0, res);
        return res;
    }

    public static void subsetsHelper(int[] nums, List<Integer> list, int cur, List<List<Integer>> res) {
        if (cur == nums.length) {
            //这里要new一个新数组，list在后续的栈帧中会被移除元素
            res.add(new ArrayList<>(list));
            return;
        }
        //添加当前元素
        list.add(nums[cur]);
        //递归式的添加下一个元素
        subsetsHelper(nums, list, cur + 1, res);
        //return到这里的时候说明数组已经遍历到最后一个，移除list的最后一个，即递归树的x层
        list.remove(list.size() - 1);
        //接着递归递归树的x-1层
        subsetsHelper(nums, list, cur + 1, res);
    }
}
