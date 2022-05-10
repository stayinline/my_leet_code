package leetcode;

public class Case125 {


    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            // 需要跳过非字母的字符，这里用Character.isLetterOrDigit()来识别
            // 当然也可以用 A和a的ascii编码值来卡区间
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            // 因为跳过非字符之后，有可能会到达边界，所以再判断一次，防止越界
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }


}
