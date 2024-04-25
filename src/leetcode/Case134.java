package leetcode;

public class Case134 {

    /**
     * 模拟法
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len;/*这里不用i++,i用offset控制即可*/) {
            int sumGas = 0, sumCost = 0;
            // 开始尝试的偏移量，从0开始，offset==len的时候，说明完整一圈
            int offset = 0;
            while (offset < len) {
                // (i + offset) % len 处理下边越界的情况，刚好利用余数达成环形遍历数组
                int j = (i + offset) % len;
                sumGas += gas[j];
                sumCost += cost[j];
                if (sumCost > sumGas) {
                    break;
                }
                offset++;
            }
            if (offset == len) {
                return i;
            } else {
                // 不足一圈，offset后移
                i = i + offset + 1;
            }
        }
        return -1;
    }


    /**
     * 这种折线图解法的错误之处在于找到的起点并不是正确的，
     * 比如[1,2,3,4,5],cost=[3,4,5,1,2]
     * 这种算法最终得到的每一个total都是0，
     * 并且，因为i=0时，不可能 gas[0]=1 & cost[0]=3 计算是-2,
     * 余量>0 && total >=0 才满足起点
     * 所以，idx=3才是正确的
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuitError(int[] gas, int[] cost) {
        int ret = -1;
        int len = gas.length;
        int total = 0;

        int maxIdx = 0;
        int maxCost = cost[0];
        // 错误之处在于maxIdx并不是正确答案，而是要找油量剩余 total +gas[i]-cost[i] 的最小值
        // total +gas[i]-cost[i] 才代表了每一站油量的剩余
        for (int i = 1; i < len; i++) {
            if (cost[i] > maxCost) {
                maxIdx = i;
                maxCost = cost[i];
            }
        }
        for (int j = maxIdx; j < 2 * len; j++) {
            total = total + (gas[j % len] - cost[j % len]);
        }
        return total >= 0 ? (maxIdx + 1) % len : -1;
    }

    /**
     * 折线图法
     * 跑完全程再回到起点，总油量剩余值的任意部分都需要在X轴以上(即大于0)，且跑到终点时：总剩余汽油量 >= 0。
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int len = gas.length;
        int total = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            total = total + (gas[i] - cost[i]);
            // 折线图的最低点就是油量的最小值，最小值记录下来，出循环后，用最终剩余油量total判断即可
            if (total < minSpare) {
                minSpare = total;
                minIndex = i;
            }
        }
        return total < 0 ? -1 : (minIndex + 1) % len;
    }


    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(new Case134().canCompleteCircuitError(gas, cost));
    }


}
