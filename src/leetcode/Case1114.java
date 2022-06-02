package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Case1114 {

    class Foo {
        private AtomicInteger count;


        public Foo() {
            count = new AtomicInteger(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            if (count.get() == 0) {
                count.incrementAndGet();
                printFirst.run();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (count.get() != 1) {

            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            count.incrementAndGet();
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (count.get() != 2) {

            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            count.incrementAndGet();
        }
    }
}
