package com.huligang.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 第n个丑数
 */
public class Problem32 {

    public int GetUglyNumber_Solution(int index) {
        if(index <= 0)
            return 0;
        List<Integer> result = new ArrayList<>();
        result.add(1);

        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        while(result.size() < index) {
            int tmp2 = result.get(i2) * 2;
            int tmp3 = result.get(i3) * 3;
            int tmp5 = result.get(i5) * 5;

            int min = Math.min(tmp2, Math.min(tmp3, tmp5));
            result.add(min);

            if (tmp2 == min) i2++;
            if (tmp3 == min) i3++;
            if (tmp5 == min) i5++;
        }

        return result.get(result.size() - 1);
    }

    public static void main(String[] args) {
        Problem32 p = new Problem32();
        System.out.println(p.GetUglyNumber_Solution(7));
    }
}
