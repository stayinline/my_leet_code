package leetcode;

public class Case633 {

    public static boolean judgeSquareSum1(int c) {
        for (int i = 0; i <= c; i++) {
            for (int j = 0; j <= c; j++) {
                if (i * i + j * j == c) {
                    return true;
                }
            }
        }
        return false;
    }

    // int sum = i * i + j * j;这里用int存储平方和，必然会越界
    // j遍历到C显然是不合适的，只需要到c^-2即可
    public static boolean judgeSquareSum2(int c) {
        for (int i = 0, j = c; i <= j; ) {
            int sum = i * i + j * j;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    /**
     * 这里存在的问题是：假设 c=3
     * 用double存储了j的初始值，那也就是存储的就是 1.732......省略后面的很多位小数
     * 此时 (long)(jj) 就会等于2，？？？啥玩意，因为j*j=1.732xxxxx*1.732xxxxx约等于2.99999999998
     * 此时 (long)(j*j) 转型之后精度丢失，变成2
     *
     * @param c
     * @return
     */
    public static boolean judgeSquareSum3(int c) {
        long i = 0;
        double j = Math.sqrt(c);
        while (i <= j) {
            long sum = i * i + (long) (j * j);
            if (sum == c) {
                return true;
            } else if (sum < c) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static boolean judgeSquareSum(int c) {
        long i = 0;
        long j = (long) Math.sqrt(c);
        while (i <= j) {
            long sum = i * i + j * j;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(judgeSquareSum(3));
        System.out.println(judgeSquareSum3(3));
    }
}
