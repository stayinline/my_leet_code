package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Case383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> mapr = getCountMap(ransomNote);
        HashMap<Character, Integer> mapm = getCountMap(magazine);

        Iterator<Map.Entry<Character, Integer>> iterator = mapm.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            if (!mapr.get(entry.getKey()).equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public HashMap<Character, Integer> getCountMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        return map;
    }
}
