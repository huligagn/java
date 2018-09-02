package com.huligang.offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 数组中取最小k个数， 三种方法：
 *  - 选择排序，o(n*k)
 *  - 快速排序，o(nlgn)
 *  - 堆排序，  o(nlgk)
 */
public class Problem29 {

    // 选择排序，复杂度o(n*k)
    public ArrayList<Integer> getLeastKNumbers(int[] a, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (a.length < k || k <=0) {
            return result;
        }
        for (int i = 0; i < k; i++) {
            int minId = i;
            int j;
            for (j = i; j < a.length; j++) {
                if (a[minId] > a[j]) {
                    minId = j;
                }
            }
            if (minId != a.length)
                swap(a, i, minId);
            result.add(a[i]);
        }
        return result;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // 快排，复杂度o(nlgn)
    public ArrayList<Integer> getLeastKNumbers2(int[] a, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (a.length < k || k <=0) {
            return result;
        }

        sort(a, 0, a.length-1);
        for (int i = 0; i < k; i++) {
            result.add(a[i]);
        }
        return result;
    }

    private void sort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int k = partition(a, lo, hi);
        sort(a, 0, k-1);
        sort(a, k+1, hi);
    }

    private int partition(int[] a, int lo, int hi) {
        int v = a[lo];
        int i = lo;
        int j = hi + 1;
        while(true) {
            while(a[++i] < v) if (i == hi) break;
            while(a[--j] > v) if (j == lo) break;
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

    //堆排序，使用优先队列， o(nlgk)
    public ArrayList<Integer> getLeastKNumbers3(int[] a, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (a.length < k || k <=0) {
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int anA : a) {
            if (maxHeap.size() < k) {
                maxHeap.offer(anA);
            } else if (maxHeap.peek() > anA) {
                maxHeap.poll();
                maxHeap.offer(anA);
            }
        }

        result.addAll(maxHeap);

        return result;
    }

    public static void main(String[] args) {
        Problem29 p = new Problem29();
        int[] a = {4,5,1,6,2,7,3,8};
        List<Integer> result = p.getLeastKNumbers3(a, 4);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
