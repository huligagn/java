package com.huligang;

import java.util.Scanner;

/**
 * 扇形涂色问题，可以用DP解决
 * N个扇形，M个颜色
 * s(1) = m
 * s(2) = m*(m-1)
 * s(3) = m*(m-1)*(m-2)
 * s(4) = (m-2)*s(3) + (m-1)*s(2)
 * ...
 * s(n) = (m-2)*s(n-1) + (m-1)*s(n-2)
 */
public class PaintSector {

    public int solve(int N, int M) {
        if (N == 1) return M;
        if (N == 2) return M*(M-1);
        if (N == 3) return M*(M-1)*(M-2);
        int tmp = 0, tmp1 = M*(M-1), tmp2 = M*(M-1)*(M-2);
        for (int i = 4; i <= N; i++){
            tmp = (M-2) * tmp2 + (M-1) * tmp1;
            tmp2 = tmp;
            tmp1 = tmp2;
        }
        return tmp;
    }

    public static void main(String[] args) {

        PaintSector paintSector = new PaintSector();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        System.out.println(paintSector.solve(N, M));
    }
}
