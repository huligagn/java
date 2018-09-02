package com.huligang.offer;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        String s = val+"";
        ListNode tmp = next;
        while(tmp != null) {
            s += (" " + tmp.val);
            tmp = tmp.next;
        }
        return s;
    }
}
