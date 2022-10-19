

import java.util.ArrayList;
import java.util.List;

public class Leetcode106 {
    //给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历，
    // postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        if (inorder.length == 1) {
            return new TreeNode(postorder[0]);
        }
        return buildHelper(inorder, postorder, 0, inorder.length, 0, postorder.length);
    }

    private TreeNode buildHelper(int[] inorder, int[] postorder, int inBegin, int inEnd, int postBegin, int postEnd) {
        if (inBegin == inEnd) {
            return null;
        }
        TreeNode cur = new TreeNode(postorder[postEnd - 1]);
        int index;
        for (index = inBegin; index < inEnd; index++) {
            if (inorder[index] == postorder[postEnd]) {
                break;
            }
        }
        cur.left = buildHelper(inorder, postorder,
                inBegin, index, postBegin,
                postBegin + index - inBegin);
        cur.right = buildHelper(inorder, postorder,
                index + 1, inEnd,
                postBegin + (index - inBegin), postEnd - 1);
        return cur;
    }
}
