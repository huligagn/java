package com.huligang.offer;

/**
 * 数组中的逆序对
 */
public class Problem34 {

    private int[] help;

    public int InversePairs(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        help = new int[array.length];
        return count(array, help, 0, array.length - 1);
    }

    private int count(int[] array, int[] help, int low, int high) {
        if (low >= high) return 0;
        int mid = (low + high) >> 1;
        int leftCount = count(array, help, low, mid) % 1000000007;
        int rightCount = count(array, help, mid+1, high) % 1000000007;
        int countNow = 0;
        int indexHelp = high;
        int j = high, i = mid;
        while(i >= low && j > mid) {
            if (array[j] < array[i]) {
                countNow += j-mid;
                if (countNow > 1000000007)
                    countNow %= 1000000007;
                help[indexHelp--] = array[i--];
            } else {
                help[indexHelp--] = array[j--];
            }
        }
        while (i>=low) {
            help[indexHelp--] = array[i--];
        }
        while (j > mid) {
            help[indexHelp--] = array[j--];
        }
        System.arraycopy(help, low, array, low, high-low+1);
        return (leftCount+rightCount+countNow) % 1000000007;
    }

    public static void main(String[] args) {
        int[] test = {1,2,3,4,5,6,7,0};
        Problem34 p = new Problem34();
        System.out.println(p.InversePairs(test));
    }
}
