package leetcode;

public class Case67 {

    public static String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int flag = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = flag;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
            }
            sb.append(sum % 2);
            flag = sum / 2;

        }
        if (flag == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();

    }

    private static char sum(char a, char b, int flag) {
        if ('1' == a) {
            if ('1' == b) {

            } else {

            }
        } else {
            if ('1' == b) {

            }
        }
        return 0;
    }

    public static String addBinary1(String a, String b) {
        Long sum = Long.parseLong(a, 2) + Long.parseLong(b, 2);
        return Long.toBinaryString(sum);
    }

    public static void main(String[] args) {
//        int a = Integer.parseInt("11", 2);
//        System.out.println(a);
//        System.out.println(addBinary("11", "1"));

        // 会溢出
        System.out.println(Long.parseLong("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", 2));
    }
}
