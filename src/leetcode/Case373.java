package leetcode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Case373 {

    public static List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        TreeMap<Integer, List<List<Integer>>> map = new TreeMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                List<List<Integer>> list = map.get(sum);
                if (null == list) {
                    list = new ArrayList<>();
                }
                List<Integer> ret = new ArrayList<>();
                ret.add(nums1[i]);
                ret.add(nums2[j]);
                list.add(ret);
                map.put(sum, list);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        map.forEach((sum, pair) -> {
            if (result.size() < k) {
                result.addAll(pair);
            }
        });

        return result.stream().limit(k).collect(Collectors.toList());
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        TreeMap<Integer, List<List<Integer>>> map = new TreeMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                List<List<Integer>> list = map.get(sum);
                if (null == list) {
                    list = new ArrayList<>();
                }
                List<Integer> ret = new ArrayList<>();
                ret.add(nums1[i]);
                ret.add(nums2[j]);
                list.add(ret);
                map.put(sum, list);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        map.forEach((sum, pair) -> {
            if (result.size() < k) {
                result.addAll(pair);
            }
        });

        return result.stream().limit(k).collect(Collectors.toList());
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        List<List<Integer>> lists = kSmallestPairs(nums1, nums2, 3);
        System.out.println(lists);
    }

}
