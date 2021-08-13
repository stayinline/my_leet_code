package leetcode;

import com.sun.org.apache.regexp.internal.REUtil;

import java.lang.reflect.Array;
import java.util.*;

public class Case378 {

    public int kthSmallest(int[][] matrix, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int[] rows : matrix) {
            for (int j = 0; j < rows.length; j++) {
                list.add(rows[j]);
            }
        }
        Collections.sort(list);
        list.notify();
        return list.get(k - 1);
    }

}
