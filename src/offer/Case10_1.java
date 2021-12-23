package offer;

public class Case10_1 {

    /**
     * f(n)=f(n-1)+f(n-2)
     *
     * @param n
     * @return
     */
    public static int fib(int n) {
        int a = 0, b = 1, c = 1;
        if (n < 1) {
            return n;
        }

        for (int i = 1; i < n; i++) {
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(fib(10));
    }
}
