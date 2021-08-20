package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Case324 {

    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] res = new int[len];

        int halfLen = (len & 1) == 1 ? len / 2 + 1 : len / 2;
        int idx = 0;
        for (int i = 0; i < halfLen; i++) {
            int j = i + halfLen;
            res[idx++] = nums[i];
            if (j < len) res[idx++] = nums[j];
        }
        for (int l = 0; l < len; l++) {
            nums[l] = res[l];
        }
    }

    public void wiggleSort2(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int len = nums.length;
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = copy[--len];
        }
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = copy[--len];
        }
    }


    public static void main(String[] args) {
        int[] arr = {4, 5, 5, 6};
        wiggleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
