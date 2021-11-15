package leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口算法框架
 *
 * @author hemaoling
 */
public class Test {

    public void slidingWindow(String s, String t) {
        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // 初始化needMap
        for (int i = 0; i < t.length(); i++) {
            needMap.put(t.charAt(i), needMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            Character c = s.charAt(right);
            right++;

            //处理窗口中的数据
//            if (needMap.containsKey(c)) {
//                window.put(c, window.getOrDefault(c, 0) + 1);
//                if (window.get(c).equals(needMap.get(c))) {
//                    valid++;
//                }
//            }

            // 判断窗口是否需要收缩
            while (windowNeedShrink()) {
                Character d = s.charAt(left);
                left++;
            }
        }

    }

    private boolean windowNeedShrink() {
        // 根据具体情况校验窗口是否收缩
        return true;
    }
}
