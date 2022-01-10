package offer;

public class Case14_1 {


    public int cuttingRope(int n) {
        // 1*1 < 1*2 < 1*2*3 ;所以 n<=3 时，最大的段数都是n-1
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3, b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }
        return (int) Math.pow(3, a) * 2;
    }
}
