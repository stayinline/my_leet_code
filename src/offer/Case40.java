package offer;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Case40 {

    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] ret = new int[k];
        if (k == 0) {
            return ret;
        }
        if (arr.length <= k) {
            return arr;
        }


        PriorityQueue<Integer> q = new PriorityQueue<>((x1, x2) -> x2 - x1);
        for (int i = 0; i < k; i++) {
            q.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (q.peek() > arr[i]) {
                q.poll();
                q.offer(arr[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            ret[i] = q.poll();
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 2, 0, 5};
        int k = 0;
        System.out.println(Arrays.toString(getLeastNumbers(arr, k)));
    }
}
