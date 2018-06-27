package com.huligang.offer;

/**
 * 二叉树A，B；判断B是不是A的子结构
 */
public class Problem17 {

    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        return check(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }

    private boolean check(TreeNode root1, TreeNode root2) {

        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.val == root2.val)
            return check(root1.left, root2.left) || check(root1.right, root2.right);
        else
            return false;
    }


}
