package offer;


public class Case58_1 {

    public static String reverseWords(String s) {
        // 删除首尾空格，分割字符串
        String[] strs = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        // 倒序遍历单词列表
        for (int i = strs.length - 1; i >= 0; i--) {
            // 遇到空单词则跳过
            if (!"".equals(strs[i])) {
                res.append(strs[i]).append(" ");
            }
        }
        return res.toString().trim();
        // 转化为字符串，删除尾部空格，并返回
    }

    public static String reverseWords2(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!"".equals(arr[i])) {
                sb.append(arr[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }


    public static void main(String[] args) {
        System.out.println(reverseWords("hello world!"));
    }
}
