package com.huligang.bishi.jingdong;

import java.util.Scanner;

public class Contrast {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Product[] inputs = new Product[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            String[] tmp = sc.nextLine().split(" ");
            Product p = new Product(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]));
            for (int j = i-1; j >=0; j--) {
                if (p.check(inputs[j])) {
                    count++;
                }
            }
            inputs[i] = p;
        }
        System.out.println(count);
    }
}

class Product {
    int a,b,c;
    public Product (int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public boolean check(Product that) {
        if (this.a < that.a && this.b < that.b && this.c < that.c) {
            this.a = Integer.MAX_VALUE;
            this.b = Integer.MIN_VALUE;
            return true;
        } else if (this.a > that.a && this.b > that.b && this.c > that.c) {
            that.a = Integer.MAX_VALUE;
            that.b = Integer.MIN_VALUE;
            return true;
        }
        return false;
    }
}
