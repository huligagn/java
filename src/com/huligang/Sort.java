package com.huligang;

/**
 * 各种排序算法
 */
public class Sort {

    /**
     * 快速排序：不稳定、NlgN、lgN
     * @param a
     * @param lo
     * @param hi
     */
    public void quickSort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        quickSort(a, lo, j-1);
        quickSort(a, j+1, hi);
    }
    private static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        int v = a[lo];
        while(true) {
            while(a[++i] < v) if (i == hi) break;
            while(a[--j] > v) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
    private static void exch(int[] a, int i, int j) {
        if (i == j) return ;
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * 冒泡排序：稳定、N~N^2、可以使用flag检测是否有序
     * @param a
     */
    public void bubbleSort(int[] a) {
        boolean flag = false;
        for (int i = 0; i < a.length - 1; i++) {
            if (flag) break;
            flag = true;
            for (int j = 1; j < a.length - i; j++) {
                if (a[j] < a[j-1]) {
                    exch(a, j, j-1);
                    flag = false;
                }
            }
        }
    }

    /**
     * 选择排序：不稳定，N^2
     * @param a
     */
    public void selectSort(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (a[min] > a[j]){
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    /**
     * 插入排序：稳定、N~N^2
     * @param a
     */
    public void insertSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0 && a[j] < a[j-1]; j--) {
                exch(a, j, j-1); //这里的交换可以变成顺序后移，见insertSort2
            }
        }
    }

    public void insertSort2(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int tmp = a[i], j;
            for (j = i; j > 0 && tmp < a[j-1]; j--) {
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
    }

    /**
     * 希尔排序：不稳定、NlgN~N^(6/5)
     * @param a
     */
    public void shellSort(int[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3*h + 1;
        while(h >= 1) {
            for (int i = h; i < N; i++){
                for (int j = i; j >= h && a[j] < a[j-h]; j -= h) {
                    exch(a, j, j-h); //这里的交换也可以变成顺序后移，见shellSort2
                }
            }
            h = h/3;
        }
    }
    public void shellSort2(int[] a) {
        int N = a.length;
        int h = 1;
        while(h < N/3) h = h*3 + 1;
        while(h >= 1) {
            for (int i = h; i < N; i++) {
                int j, tmp = a[i];
                for (j = i; j >= h && tmp < a[j-h]; j -= h) {
                    a[j] = a[j-h];
                }
                a[j] = tmp;
            }
            h = h/3;
        }
    }

    /**
     * 归并排序: 稳定、NlgN
     * @param a
     * @param lo
     * @param hi
     * @param help
     */
    public void mergeSort(int[] a, int lo, int hi, int[] help) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        mergeSort(a, lo, mid, help);
        mergeSort(a, mid+1, hi, help);
        merge(a, lo, mid, hi, help);
    }
    private void merge(int[] a, int lo, int mid, int hi, int[] help) {
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++)
            help[k] = a[k];
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = help[j++];
            else if (j > hi) a[k] = help[i++];
            else if (help[i] < help[j]) a[k] = help[i++];
            else a[k] = help[j++];
        }
    }

    /**
     * TODO: 堆排序还没写
     * @param args
     */



    public static void main(String[] args) {
        Sort sort = new Sort();

        int[] a = {9,8,7,6,5,4,3,2,1};
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

        System.out.println("\n---------");
//        sort.quickSort(a, 0, a.length-1);
//        sort.bubbleSort(a);
//        sort.insertSort(a);
//        sort.insertSort2(a);
//        sort.shellSort(a);
//        sort.shellSort2(a);

        int[] tmp = new int[a.length];
        sort.mergeSort(a, 0, a.length-1, tmp);
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }
}
