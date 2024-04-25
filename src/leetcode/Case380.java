package leetcode;

import java.util.*;

public class Case380 {

    class RandomizedSet {

        private List<Integer> values;
        private Map<Integer, Integer> map;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            values = new ArrayList<>();
            map = new HashMap<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (map.get(val) != null) {
                return false;
            }

            map.put(val, values.size());
            values.add(values.size(), val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (map.get(val) == null) {
                return false;
            }
            // 数组中间位置删除的时候，要挪动尾部最后一个元素到中间空位
            int tailVal = values.get(values.size() - 1);
            int idxOfVal = map.get(val);

            map.put(tailVal, idxOfVal);
            values.set(idxOfVal, tailVal);

            values.remove(values.size() - 1);
            map.remove(val);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            int index = new Random().nextInt(values.size());
            return values.get(index);
        }

    }
}
