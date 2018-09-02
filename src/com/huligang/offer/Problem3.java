package com.huligang.offer;

import java.util.ArrayList;

/**
 * 逆序输出链表
 */
public class Problem3 {

    private ArrayList<Integer> arrayList = new ArrayList<>();

    public ArrayList<Integer> printListInverse(ListNode listNode) {
        if (listNode != null) {
            printListInverse(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        Problem3 p = new Problem3();
        ArrayList<Integer> result = p.printListInverse(listNode);
        System.out.println(result.toString());
    }
}
