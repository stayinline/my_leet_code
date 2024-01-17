package algorithm;

import java.util.HashMap;

/**
 * 该算法是暴力匹配的改进版
 * <p>
 * 给所有子串增加了一个哈希值，通过计算目标穿的哈希值，和子串哈希缓存对比；
 * 相同，则比较哈希对应的子串和目标串是否相同；
 * 不同，则一定不会匹配到；
 * 类似于布隆过滤器的思想
 */
public class StringParttenRK {

    public HashMap<Integer, String> hashMap;

    public String str;

    // 一般是一个素数
    public Integer x = 7;

    public StringParttenRK(String str) {
        this.str = str;
        this.hashMap = new HashMap<>();
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 2; j < str.length() - 1; j++) {
                String cur = str.substring(i, j);
                Integer key = getHashKey(cur);
                hashMap.put(key, cur);
            }
        }
    }

    /**
     * 这种方式被称为霍纳法则，简单地将每个字符乘以一个系数，然后加和
     */
    private Integer getHashKey(String cur) {
        int sum = cur.indexOf(0);
        for (int i = 1; i < cur.length() - 1; i++) {
            sum = sum * x + cur.indexOf(i);
        }
        return sum;
    }

    public boolean hasSubStr(String a, String b) {
        StringParttenRK rk = new StringParttenRK(a);
        Integer bHashKey = rk.getHashKey(b);
        String s = rk.hashMap.get(bHashKey);
        if (b.equals(s)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("123456".substring(2, 4));
    }
}
