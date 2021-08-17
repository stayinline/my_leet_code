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
     * 折线图法
     * 跑完全程再回到起点，总油量剩余值的任意部分都需要在X轴以上(即大于0)，且跑到终点时：总剩余汽油量 >= 0。
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }

        return spare < 0 ? -1 : (minIndex + 1) % len;
    }


}
