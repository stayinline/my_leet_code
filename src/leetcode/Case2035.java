package leetcode;

import java.util.*;

public class Case2035 {
    public static int minimumDifference1(int[] nums) {
        int n = nums.length / 2;
        int sum = Arrays.stream(nums).sum();
        int[] A = new int[n], B = new int[n];
        List<List<Integer>> X = new ArrayList<>(), Y = new ArrayList<>();

        splitNums(nums, n, A, B, X, Y);

        enumAllSum(n, A, B, X, Y);

        // 将Y进行排序，以便二分查找
        for (int i = 0; i <= n; i++) {
            Collections.sort(Y.get(i));
        }

        // 进行二分查找答案
        int ans = Integer.MAX_VALUE;
        for (int k = 0; k <= n; k++) {
            List<Integer> x = X.get(k);
            List<Integer> y = Y.get(n - k);
            for (int i : x) {
                int l = 0, r = y.size() - 1;
                while (l < r) {
                    int mid = (r - l) / 2 + l;
                    int j = y.get(mid);
                    if (i + j < sum / 2) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                ans = Math.min(ans, Math.abs((sum - i - y.get(l) - (i + y.get(l)))));
            }
        }
        return ans;
    }

    // 枚举两个子集中的所有加和
    private static void enumAllSum(int n, int[] a, int[] b, List<List<Integer>> x, List<List<Integer>> y) {
        for (int mask = 0; mask < 1 << n; mask++) {
            // Integer.bitCount ：统计二进制的比特位
            int key = Integer.bitCount(mask);
            int cnt_a = 0, cnt_b = 0;
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) {
                    cnt_a += a[i];
                    cnt_b += b[i];
                }
            }
            x.get(key).add(cnt_a);
            y.get(key).add(cnt_b);
        }
    }

    // 分割两个子集
    private static void splitNums(int[] nums, int n, int[] a, int[] b, List<List<Integer>> x, List<List<Integer>> y) {
        for (int i = 0; i <= n; i++) {
            if (i < n) {
                a[i] = nums[i];
                b[i] = nums[i + n];
            }
            x.add(new ArrayList<>());
            y.add(new ArrayList<>());
        }
    }


    public static int minimumDifference(int[] nums) {
        // 前 n 个元素元素组合情况存储在left 中, 后 n 个元素组合请情况存储在 right 中
        // Map<元素个数, Set<key个元素的总和>>
        Map<Integer, TreeSet<Integer>> left = new HashMap<>();
        Map<Integer, TreeSet<Integer>> right = new HashMap<>();

        int min = Integer.MAX_VALUE;
        int totalSum = 0;

        int n = nums.length / 2;
        // 切分和初始化左右两个数组
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            if (i < n) {
                left.put(i + 1, new TreeSet<>());
            } else {
                right.put(i - n + 1, new TreeSet<>());
            }
        }

        dfs(nums, 0, 0, 0, n, left);
        dfs(nums, 0, 0, n, 2 * n, right);

        // 情况一, 一部分元素在左侧，一部分元素在右侧
        for (int i = 1; i < n; i++) {
            TreeSet<Integer> set = left.get(i);
            for (int leftSum : set) {
                // 前 i 个元素在  left 中, 后  n - i 个元素在 right 中
                // 最佳情况是分成两侧相等即  totalSum / 2, 寻找最佳组合最近的组合
                Integer rightSum = right.get(n - i).ceiling(totalSum / 2 - leftSum);
                if (null != rightSum) {
                    int sum = leftSum + rightSum;
                    min = Math.min(min, Math.abs(sum - (totalSum - sum)));
                }

                rightSum = right.get(n - i).floor(totalSum / 2 - leftSum);
                if (null != rightSum) {
                    int sum = leftSum + rightSum;
                    min = Math.min(min, Math.abs(sum - (totalSum - sum)));
                }

                if (min == 0) {
                    return 0;
                }
            }
        }

        // 情况二,  所有元素都来源与一侧
        TreeSet<Integer> set = left.get(n);
        for (int sum : set) {
            min = Math.min(min, Math.abs(sum - (totalSum - sum)));
        }

        return min;
    }

    /**
     * 递归枚举所有的元素组合,将元素组合情况存 Map<元素个数, Set<key个元素的总和>> 中
     *
     * @param nums
     * @param sum     已选数组和
     * @param count   已选数个数
     * @param idx     当前索引
     * @param limit   索引边界
     * @param visited
     */
    public static void dfs(int[] nums, int sum, int count, int idx, int limit, Map<Integer, TreeSet<Integer>> visited) {
        if (visited.containsKey(count)) {
            visited.get(count).add(sum);
        }

        if (idx >= limit) return;

        // 选择当前元素
        dfs(nums, sum + nums[idx], count + 1, idx + 1, limit, visited);

        // 不选当前元素
        dfs(nums, sum, count, idx + 1, limit, visited);
    }


    public static void main(String[] args) {
        int[] nums = {2, -1, 0, 4, -2, -9};
        System.out.println(minimumDifference(nums));
    }

}
