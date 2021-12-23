package offer;

public class Case10_2 {

    public static int numWays(int n) {
        int a = 0, b = 1, c = 1;
        if (n <=1) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(numWays(10));
    }
}
