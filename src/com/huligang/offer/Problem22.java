package com.huligang.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下打印二叉树，同层从左至右
 * 广度优先搜索
 */
public class Problem22 {

    public ArrayList<Integer> printTree(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> help = new LinkedList<>();

        help.offer(root);
        while(!help.isEmpty()) {
            TreeNode tmp = help.poll();
            if (tmp.left != null)
                help.offer(tmp.left);
            if (tmp.right != null)
                help.offer(tmp.right);
            result.add(tmp.val);
        }

        return result;
    }

    public static void main(String[] args) {
        Problem22 p = new Problem22();

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);

        System.out.println(p.printTree(treeNode).toString());
    }
}
