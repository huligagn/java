package com.huligang.offer;

/**
 * 输入一个链表，输出该链表的倒数第k个节点
 */
public class Problem14 {

    public int theLastKthNode(ListNode node, int k) {

        if (node == null)
            throw new RuntimeException("空链表");
        ListNode first = node;
        for (int i = 0; i < k; i++) {
            if (first == null)
                throw new RuntimeException("该链表长度小于k");
            first = first.next;
        }
        ListNode second = node;
        while(first != null) {
            first = first.next;
            second = second.next;
        }

        return second.val;
    }

    public static void main(String [] args) {
        ListNode node = new ListNode(5);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(1);
        Problem14 p = new Problem14();
        System.out.println(p.theLastKthNode(node,1));
        System.out.println(p.theLastKthNode(node,2));
        System.out.println(p.theLastKthNode(node,3));
        System.out.println(p.theLastKthNode(node,4));
        System.out.println(p.theLastKthNode(node,5));
//        System.out.println(p.theLastKthNode(node,6));
    }
}
