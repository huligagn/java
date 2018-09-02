package com.huligang.offer;

/**
 * 输入前序遍历和中序遍历，重建二叉树
 * TODO: 测试案例还没写
 */
public class Problem4 {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return reConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre>endPre || startIn>endIn)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);

        for(int i = startIn; i < endIn; i++) {
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre+1, startPre+i-startIn, in, startIn, i-1);
                root.right = reConstructBinaryTree(pre, startPre+i-startIn+1, endPre, in, i+1, endIn);
                break;
            }
        }

        return root;
    }
}
