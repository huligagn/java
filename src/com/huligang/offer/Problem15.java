package com.huligang.offer;

/**
 * 反转链表
 */
public class Problem15 {

    public ListNode reverseList(ListNode node) {
        if (node == null)
            return null;

        ListNode pre=null, next;

        while(node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);

        System.out.println(node.toString());

        Problem15 p = new Problem15();
        ListNode rNode = p.reverseList(node);
        System.out.println(rNode.toString());
    }
}
