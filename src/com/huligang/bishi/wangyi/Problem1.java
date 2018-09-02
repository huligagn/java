package com.huligang.bishi.wangyi;

import java.util.Scanner;

public class Problem1 {

    private static class Time {
        private int hh;
        private int mm;
        private int ss;

        Time(String s) {
            String[] tmp = s.split(":");
            assert tmp.length == 3;
            this.hh = Integer.parseInt(tmp[0]);
            this.mm = Integer.parseInt(tmp[1]);
            this.ss = Integer.parseInt(tmp[2]);
        }

        boolean check() {
            return this.hh <= 23 && this.mm <= 59 && this.ss <= 59;
        }

        void magic() {
            if (this.hh > 23) {
                this.hh = this.hh % 10;
            }
            if (this.mm > 59) {
                this.mm = this.mm % 10;
            }
            if (this.ss > 59) {
                this.ss = this.ss % 10;
            }
        }

        @Override
        public String toString() {
            return String.format("%02d:%02d:%02d", this.hh, this.mm, this.ss);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        Time[] result = new Time[N];
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            result[i] = new Time(s);
            if (! result[i].check()) {
                result[i].magic();
            }
        }
        for (int i = 0; i< N; i++) {
            System.out.println(result[i].toString());
        }
    }
}
