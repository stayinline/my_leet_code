package leetcode;

public class Case191 {


    public Integer sum = 0;

    public int[] statisticalResult(int[] array) {
        if (null == array || array.length == 0) {
            return array;
        }
        int length = array.length;
        int[] leftProduct = new int[length];
        int[] rightProduct = new int[length];
        int[] result = new int[length];

        leftProduct[0] = 1;
        for (int i = 1; i < length; i++) {
            leftProduct[i] = array[i - 1] * leftProduct[i - 1];
        }

        rightProduct[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            rightProduct[i] = array[i + 1] * rightProduct[i + 1];
        }

        for (int i = 0; i < length; i++) {
            result[i] = leftProduct[i] * rightProduct[i];
        }

        return result;

    }




}
