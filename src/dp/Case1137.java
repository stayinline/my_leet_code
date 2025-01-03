package dp;

public class Case1137 {

    public static int tribonacci(int n) {
        int t0 = 0, t1 = 1, t2 = 1;
        int tn = 0;
        if (n <= 1) {
            return n;
        } else if (n == 2) {
            return t2;
        } else {
            for (int i = 0; i < n - 2; i++) {
                tn = t0 + t1 + t2;
                t0 = t1;
                t1 = t2;
                t2 = tn;
            }
            return tn;
        }
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(4));
        System.out.println(tribonacci(5));
    }
}
