package offer2;

public class Case2 {


    public static String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), flag = 0;
        for (int i = 0; i < n; ++i) {
            flag += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            flag += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (flag % 2 + '0'));
            flag /= 2;
        }

        if (flag > 0) {
            ans.append('1');
        }
        return ans.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(addBinary("11", "10"));
    }

}
