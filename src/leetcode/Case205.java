package leetcode;

public class Case205 {
    public static boolean isIsomorphic(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
    }
}
