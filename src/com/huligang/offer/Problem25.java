package com.huligang.offer;

import java.util.HashMap;

/**
 * 复杂链表的复制
 */
public class Problem25 {

    // 这是一个错误的解法，因为random和next出现环的时候，就死循环了
    @Deprecated
    public RandomListNode wrongClone (RandomListNode head) {
        if (head == null)
            return null;
        RandomListNode tmp = new RandomListNode(head.label);
        tmp.next = wrongClone(head.next);
        tmp.random = wrongClone(head.random);

        return tmp;
    }

    // 这个问题可以分为两个步骤，一个是节点复制，一个是关系复制；这样做有个关键点是节点复制之后的新旧对应关系如何保存
    // 可以新建一个map，也可以在原来的链表上存新的节点
    private HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
    public RandomListNode CloneWithMap (RandomListNode head) {
        if (head == null)
            return null;
        RandomListNode backupHead = head;
        while (backupHead != null) {
            map.put(backupHead, new RandomListNode(backupHead.label));
            if (backupHead.random != null)
                map.put(backupHead.random, new RandomListNode(backupHead.random.label));
            backupHead = backupHead.next;
        }
        backupHead = head;
        while (backupHead != null) {
            map.get(backupHead).next = map.get(backupHead.next);
            if (backupHead.random != null)
                map.get(backupHead).random = map.get(backupHead.random);
            backupHead = backupHead.next;
        }
        return map.get(head);
    }

    //另一种解法是利用原有链表存储新节点，然后拆分；这样做就自动保存了对应关系
    public RandomListNode Clone(RandomListNode head) {
        if (head == null)
            return null;

        RandomListNode backupHead = head;
        while (backupHead != null) {
            RandomListNode next = backupHead.next;
            RandomListNode tmp = new RandomListNode(backupHead.label);
            if (backupHead.random != null)
                tmp.random = new RandomListNode(backupHead.random.label);
            tmp.next = next;
            backupHead.next = tmp;
            backupHead = next;
        }

        backupHead = head;
        RandomListNode newList = head.next;
        RandomListNode tmp;

        while (backupHead != null) {
            tmp = backupHead.next;
            backupHead.next = backupHead.next.next;
            tmp.next = backupHead.next == null ? null : backupHead.next.next;

            backupHead = backupHead.next;
        }

        return newList;
    }
}
