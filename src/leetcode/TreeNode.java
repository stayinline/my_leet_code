package leetcode;


import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class TreeNode {
    public int val;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static String test(String s) {
        s = "abcd";
        System.out.println("变更：s=" + s);
        return s;
    }

    class Moudle {
        //执行测试用例
        public void executeCase() {
        }
    }

    public static void execute10Module(List<Moudle> moudles) {
        moudles.forEach(moudle -> {
            new Thread(() -> {
                moudle.executeCase();
            }).start();
        });
    }

    public synchronized void test() {


    }

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger atomicInteger = new AtomicInteger(0);
        atomicInteger.incrementAndGet();
        int a = 0;

        TestMyThread myThread = new TestMyThread();
        //myThread.run(atomicInteger); //准确的
        myThread.run(a); //准确的
//
//        synchronized () {
//            //1
//            //2
//            //3
//        }
//
//        Lock lock = new ReentrantLock(false);
//        Lock lock2 = new ReentrantLock(true);
//        boolean isGet = lock.tryLock();
//        if(isGet){
//            //dosomething
//
//            lock.lock();
//
//            lock.unlock();
//        }else {
//
//        }

//        for (int i = 0; i < 10; i++) {
//            Thread thread2 = new Thread(
//                    () -> {
//                        System.out.println("thread2 方式做的事情");
//                        atomicInteger++;
//                        a++;
//                    }
//            );

//            thread2.start();

//        }
    }
}