package offer;

public class Case46 {

    class Solution {
        public int translateNum(int num) {
            String s = String.valueOf(num);
            int a = 1, b = 1;
            for (int i = s.length() - 2; i > -1; i--) {
                String tmp = s.substring(i, i + 2);
                int c = isValid(tmp) ? a + b : a;
                b = a;
                a = c;
            }
            return a;
        }

        private boolean isValid(String tmp) {
            return tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0;
        }
    }

}
