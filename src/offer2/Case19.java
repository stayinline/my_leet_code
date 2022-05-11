package offer2;

public class Case19 {

    /**
     *
     */
    public static boolean validPalindrome(String s) {
        if (s == null || "".equals(s) || s.length() == 1) {
            return true;
        }
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if (c1 != c2) {
                return isValid(s, i, j - 1) || isValid(s, i + 1, j);
            }
        }
        return true;
    }

    public static boolean isValid(String s, int l, int r) {
        for (int i = l, j = r; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    // 暴力法：
//    public static boolean validPalindrome1(String s) {
//        if (s == null || "".equals(s) || s.length() == 1) {
//            return true;
//        }
//        for (int i = 0; i < s.length(); i++) {
//            String tmp = s.substring(0, i) + s.substring(i + 1);
//            if (isValid(tmp, 0, tmp.length() - 1)) {
//                return true;
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        String s = "aydmda";
        System.out.println(validPalindrome(s));
        String tmp = s.substring(0, 1) + s.substring(2);

        System.out.println(tmp);
    }
}
