package com.huligang.offer;

/**
 * 从左到右从上到下递增的二维数组，查找某数
 */
public class Problem1 {

    public boolean find(int[][] array, int target) {
        int row = 0;
        int col = array[0].length-1;
        while (row < array.length && col >= 0) {
            if(target == array[row][col]) {
                return true;
            } else if (target < array[row][col]) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] a = {{1,6,7},
                {2,7,9},
                {4,8,11},
                {12,13,15}};
        int target = 3;
        Problem1 p = new Problem1();
        if (p.find(a, target)) {
            System.out.println("Found it");
        } else {
            System.out.println("Not found.");
        }
    }
}
