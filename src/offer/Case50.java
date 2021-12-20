package offer;

public class Case50 {

    public static char firstUniqChar(String s) {
        char ret = ' ';
        int minIdx = Integer.MAX_VALUE;
        for (char c = 'a'; c <= 'z'; c++) {
            int idx = s.indexOf(c);

            if (idx != -1 && s.lastIndexOf(c) == idx) {
                if (idx < minIdx) {
                    minIdx = idx;
                    ret = c;
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("z"));
    }
}
