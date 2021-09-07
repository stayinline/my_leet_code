package leetcode;

import java.util.*;

public class Case218 {
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        // queue记录每个坐标三元组的右节点和高度，并且使用高度最为优先权重，即队首一定是高度最大的那一个
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        // 记录左右宽度的每一个坐标
        List<Integer> boundaries = new ArrayList<>();
        for (int[] building : buildings) {
            boundaries.add(building[0]);
            boundaries.add(building[1]);
        }
        // 将左右宽度节点的坐标排序
        Collections.sort(boundaries);

        List<List<Integer>> ret = new ArrayList<>();
        int n = buildings.length, idx = 0;
        // 遍历这个左右节点的集合，判断对应的宽度、高度是否被覆盖
        for (int boundary : boundaries) {
            while (idx < n && buildings[idx][0] <= boundary) {
                // 没有被覆盖，将右节点和高度入队
                queue.offer(new int[]{buildings[idx][1], buildings[idx][2]});
                idx++;
            }
            while (!queue.isEmpty() && queue.peek()[0] <= boundary) {
                // 队首的宽度没有覆盖当前三元组的宽度，需要将队首元素出队
                queue.poll();
            }

            // 最大值高度就是队首元素的高度
            int max = queue.isEmpty() ? 0 : queue.peek()[1];
            if (ret.size() == 0 || max != ret.get(ret.size() - 1).get(1)) {
                ret.add(Arrays.asList(boundary, max));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        List<List<Integer>> skyline = getSkyline(buildings);
        System.out.println(skyline);
    }
}
