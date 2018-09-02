package com.huligang.offer;

/**
 * 输出旋转（非递减）数组的最小值
 */
public class Problem6 {

    public int findMin(int[] array) {

        if (array.length == 0)
            return 0;

        int lo = 0, hi = array.length-1;

        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (array[mid] > array[hi]) {
                lo = mid+1; // 这里需要注意
            } else {
                hi = mid;
            }
        }

        return array[lo];
    }

    public static void main(String[]  args) {
        int[] a = {3,4,5,6,6,6,1,2};
        Problem6 p = new Problem6();
        System.out.println(p.findMin(a));
    }
}
