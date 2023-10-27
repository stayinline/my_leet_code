package leetcode;

public class case165 {
    //错误
    public static int compareVersion1(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            // 将每一个.号之间的转换成数字，然后比较
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; ++i) {
                //这种写法的错误之处在于不是要跳过'0'，1.100和1.10，前者是100>后者的10
                if (version1.charAt(i) != '0') {
                    x = x * 10 + version1.charAt(i);
                }
            }
            ++i; // 跳过点号
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; ++j) {
                if (version2.charAt(j) != '0') {
                    y = y * 10 + version2.charAt(j);
                }
            }
            ++j; // 跳过点号
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }

    public static int compareVersion(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            // 将每一个.号之间的转换成数字，然后比较
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; ++i) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            ++i; // 跳过点号
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; ++j) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            ++j; // 跳过点号
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(compareVersion("1.1", "1.10"));
    }

}
