package com.huligang.offer;


import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 */
public class Problem24 {

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {

        if (root == null)
            return listAll;
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<>(list));
        }
        findPath(root.left, target);
        findPath(root.right, target);
        list.remove(list.size() - 1);
        return listAll;
    }
}
