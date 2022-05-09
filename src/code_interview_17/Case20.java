package code_interview_17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Case20 {

    class MedianFinder1 {
        private int size = 0;
        private List<Integer> left;
        private List<Integer> right;
        private double mid = 0;

        /**
         * initialize your data structure here.
         */
        public MedianFinder1() {
            left = new ArrayList<>();
            right = new ArrayList<>();
        }


        public void addNum(int num) {
            left.add(num);
            size++;
            Collections.sort(left);
            if (size % 2 == 0) {
                mid = (left.get(size / 2) - left.get(size / 2 - 1)) / 2.0 + left.get(size / 2 - 1);
            } else {
                mid = left.get(size / 2);
            }

        }

        public double findMedian() {
            return mid;
        }
    }

    class MedianFinder {
        ArrayList<Integer> list = new ArrayList<>();

        /** initialize your data structure here. */
        public MedianFinder() {

        }

        public void addNum(int num) {
            list.add(binarySearch(num), num);
        }

        public double findMedian() {
            int n = list.size();
            return (n & 1) == 0 ? (list.get(n / 2) + list.get(n / 2 - 1)) / 2.0 : list.get(n / 2);
        }

        private int binarySearch(int target) {
            int l = 0, r = list.size() - 1;
            while (r >= l) {
                int mid = (l + r) >> 1;
                if (list.get(mid) == target) {
                    return mid;
                } else if (list.get(mid) < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return l;
        }
    }


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
