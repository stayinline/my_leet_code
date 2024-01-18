package leetcode;

public class Case201 {

    /**
     * 暴力法超时
     */
    public static int rangeBitwiseAnd1(int left, int right) {

        int ret = left;
        for (int i = 1; i <= (right - left); i++) {
            ret &= (left + i);
        }
        return ret;
    }

    public static int rangeBitwiseAnd(int left, int right) {

        if (Integer.toBinaryString(left).length() != Integer.toBinaryString(right).length()) {
            return 0;
        }
        int ret = left;
        for (int i = 1; i <= (right - left); i++) {
            ret &= (left + i);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7));
        System.out.println(rangeBitwiseAnd(1, 2147483647)); // 超时
    }

}
