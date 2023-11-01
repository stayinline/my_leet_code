package leetcode;

public class Case392 {
    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = i;
        for (; i < s.length() && j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }
        return i == s.length() && j <= t.length();
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
}
