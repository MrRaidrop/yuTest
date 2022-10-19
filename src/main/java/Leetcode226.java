import org.junit.Test;

import java.util.ArrayDeque;

public class Leetcode226 {
    //给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.pop();
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
                if (cur.left != null) {
                    deque.push(cur.left);
                }
                if (cur.right != null) {
                    deque.push(cur.right);
                }
            }
        }
        return root;
    }

}
