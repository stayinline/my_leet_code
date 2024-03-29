package leetcode;

public class Case9 {
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-123) + "=false");

        System.out.println(isPalindrome(121) + "=true");

        System.out.println(isPalindrome(123) + "=false");


    }
}
