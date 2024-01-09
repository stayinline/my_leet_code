package code_interview_17;

import java.util.*;

public class Main {
    public static void freqSort(String[] words) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> maxHeap = new PriorityQueue<>(
                (w1, w2) -> map.get(w1).equals(map.get(w2))
                        ? w2.compareTo(w1)
                        : map.get(w2) - map.get(w1));
        maxHeap.addAll(map.keySet());
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            res.add(maxHeap.poll());
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "you", "i", "love", "leetcode", "i", "love", "coding"};
        freqSort(words);
    }
}
