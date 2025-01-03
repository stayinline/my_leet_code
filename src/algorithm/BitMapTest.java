package algorithm;


import java.util.Random;

public class BitMapTest {

    public static void test() {
        Random random = new Random();
        int randomValue = random.nextInt(1000);
        System.out.println(randomValue);
//        BitMap myBitMap = new BitMap(1000);
//        for (int i = 0; i < 1000; i++) {
//            myBitMap.atPut(i, true);
////            bitMap.at(i);bitMap.at(i)是用来检查位于索引i处的值是否为true。如果在索引i处，值为true，那么它会返回true，否则返回false。
//        }
//        // 检查随机数是否存在
//        if (myBitMap.at(randomValue)) {
//            System.out.println("随机数 " + randomValue + " 存在.");
//        } else {
//            System.out.println("随机数 " + randomValue + " 不存在.");
//        }

    }

    public static void main(String[] args) {
        test();


    }

    public class MyBitMap {
        // Java 中 char 类型占 16bit，也即是 2 个字节
        private char[] bytes;
        private int nbits;

        public MyBitMap(int nbits) {
            this.nbits = nbits;
            this.bytes = new char[nbits / 16 + 1];
        }

        public void set(int k) {
            if (k > nbits) return;
            int byteIndex = k / 16;
            int bitIndex = k % 16;
            bytes[byteIndex] |= (1 << bitIndex);
        }

        public boolean get(int k) {
            if (k > nbits) return false;
            int byteIndex = k / 16;
            int bitIndex = k % 16;
            return (bytes[byteIndex] & (1 << bitIndex)) != 0;
        }
    }
}
