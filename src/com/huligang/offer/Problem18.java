package com.huligang.offer;

/**
 * 操作给定二叉树，使之变成源二叉树的镜像
 */
public class Problem18 {

    public void mirror(TreeNode root) {

        if (root == null)
            return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        mirror(root.left);
        mirror(root.right);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Problem18 p = new Problem18();
        p.mirror(root);

        assert root.val == 1;
        assert root.left.val == 3;
        assert root.right.val == 2;
    }
}
