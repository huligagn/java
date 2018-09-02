package com.huligang.offer;

/**
 * 把字符串中的空替换为%20
 */
public class Problem2 {

    public String replaceSpace(StringBuffer str) {

        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceNum++;
            }
        }

        int indexOld = str.length()-1;
        int indexNew = str.length()-1 + spaceNum*2;

        str.setLength(indexNew+1);

        for (; indexNew >= 0; indexOld--) {
            if (str.charAt(indexOld) == ' ') {
                str.setCharAt(indexNew--, '0');
                str.setCharAt(indexNew--, '2');
                str.setCharAt(indexNew--, '%');
            } else
                str.setCharAt(indexNew--, str.charAt(indexOld));
        }

        return str.toString();

    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("You are lucy.");
        Problem2 p = new Problem2();
        System.out.println(p.replaceSpace(str));
    }
}
