package leetcode;

public class Case134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len;/*这里不用i++,i用offset控制即可*/) {
            int sumOfGas = 0, sumOfCost = 0;
            // 开始尝试的偏移量，从0开始，offset==len的时候，说明完整一圈
            int offset = 0;
            while (offset < len) {
                // (i + offset) % len 处理下边越界的情况，刚好利用余数达成环形遍历数组
                int j = (i + offset) % len;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
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

}
