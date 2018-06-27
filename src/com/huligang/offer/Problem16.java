package com.huligang.offer;

/**
 * merge 两个单调递增的链表
 */
public class Problem16 {

    public ListNode merge(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null)
            return listNode2;
        if (listNode2 == null)
            return listNode1;

        if (listNode1.val <= listNode2.val) {
            ListNode head = listNode1;
            head.next = merge(listNode1.next, listNode2);
            return head;
        } else {
            ListNode head = listNode2;
            head.next = merge(listNode1, listNode2.next);
            return head;
        }
    }

    public static void main(String[] args) {
        Problem16 p = new Problem16();
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(3);
        listNode1.next.next = new ListNode(5);
        System.out.println(listNode1);

        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(4);
        listNode2.next.next = new ListNode(6);
        System.out.println(listNode2);

        ListNode result = p.merge(listNode1, listNode2);
        System.out.println(result.toString());
    }
}
