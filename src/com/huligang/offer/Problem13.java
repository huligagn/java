package com.huligang.offer;

/**
 * 调整数组，奇数在前，偶数在后，保持稳定
 */
public class Problem13 {

    public void reOrder(int[] array) {
        int i,j;
        for (i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                boolean flag = true;
                for (j = i; j < array.length; j++) {
                    if (array[j] % 2 != 0) {
                        flag = false;
                        break;
                    }
                }

                if (flag)
                    break;
                else {
                    int tmp = array[j];
                    for(int k=j; k > i; k--) {
                        array[k] = array[k-1];
                    }
                    array[i] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8};
        Problem13 p = new Problem13();
        p.reOrder(a);

        for (int i =0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
