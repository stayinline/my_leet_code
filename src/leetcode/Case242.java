package leetcode;

public class Case242 {
    public static boolean isAnagram(String s, String t) {
        int ls = s.length(), lt = t.length();
        if (ls != lt) {
            return false;
        }
        int[] ct = new int[26];
        for (int i = 0; i < ls; i++) {
            ct[t.charAt(i) - 'a'] += 1;
        }

        int[] cs = new int[26];
        for (int i = 0; i < ls; i++) {
            cs[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < ct.length; i++) {
            if (cs[i] != ct[i]) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        //System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("nl", "cx"));
    }
}
