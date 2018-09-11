package com.huligang.offer;

/**
 * 两个链表的第一个公共节点
 */
public class Problem35 {

    // 方法一：遍历，o(N^2)
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        while(pHead1 != null) {
            ListNode tmp = pHead2;
            while(tmp != null) {
                if (pHead1 == tmp)
                    return pHead1;
                else
                    tmp = tmp.next;
            }
            pHead1 = pHead1.next;
        }
        return pHead1;

    }

    // 两次遍历求长度差
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int count1=0,count2=0;
        ListNode p1 = pHead1, p2 = pHead2;
        while(p1 != null) {
            count1++;
            p1 = p1.next;
        }
        while(p2 != null) {
            count2++;
            p2 = p2.next;
        }

        if (count1 > count2) {
            int count = count1 - count2;
            while(count > 0) {
                pHead1 = pHead1.next;
                count--;
            }
        } else {
            int count = count2 - count1;
            while(count > 0) {
                pHead2 = pHead2.next;
                count--;
            }
        }

        while (pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }

    // 简化写法，非常漂亮
    public ListNode findFirstCommonNodeBetter(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1, p2 = pHead2;
        while (p1 != p2) {
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }
}
