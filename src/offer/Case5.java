package offer;

public class Case5 {

    class Solution {
        public String replaceSpace(String s) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    sb.append("%20");
                } else {
                    sb.append(String.valueOf(s.charAt(i)));
                }
            }
            return sb.toString();
        }
    }
}
