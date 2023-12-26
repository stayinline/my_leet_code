package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 请注意，返回的 规范路径 必须遵循下述格式：
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 */
public class Case71 {

    public static String simplifyPath(String path) {

        String[] array = path.split("/");
        Deque<String> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (String s : array) {
            if ("..".equals(s)) {
                if (!queue.isEmpty()) {
                    queue.pollLast();
                }
            } else if (s.length() > 0 && !".".equals(s)) {
                queue.offerLast(s);
            }
        }
        if (queue.isEmpty()) {
            sb.append("/");
        } else {
            while (!queue.isEmpty()) {
                sb.append("/");
                sb.append(queue.pollFirst());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home//foo/"));
    }

}
