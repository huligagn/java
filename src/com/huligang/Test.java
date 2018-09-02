package com.huligang;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        String a = " hh";
        List<String> r = Arrays.asList(a.split(" "));
        System.out.println(r.get(0).equals(""));

    }
}
