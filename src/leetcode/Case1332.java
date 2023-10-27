package leetcode;

public class Case1332 {
    public static int removePalindromeSub(String s) {

        return isPalind(s) ? 1 : 2;

    }

    public static boolean isPalind(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(removePalindromeSub("baabb"));
    }
}
