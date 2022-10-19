import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leetcode101 {
    //给你一个二叉树的根节点 root ， 检查它是否轴对称。
    boolean res = true;
    public boolean isSymmetric(TreeNode root) {
        if (root==null) {
            return true;
        }
        helper(root.left, root.right);
        return res;
    }

    private void helper(TreeNode q, TreeNode p) {
        if (q==null&&p == null) {
            return;
        }
        if (q==null||p==null||q.val!=p.val) {
            res = false;
            return;
        }
        helper(q.left,p.right);
        helper(q.right,p.left);
    }

    @Test
    public void test() {
        TreeNode b1 = new TreeNode(4, null, null);
        TreeNode b2 = new TreeNode(3, null, null);
        TreeNode b3 = new TreeNode(3, null, null);
        TreeNode b4 = new TreeNode(4, null, null);
        TreeNode m1 = new TreeNode(2, b1, b2);
        TreeNode m2 = new TreeNode(2, b3, b4);
        TreeNode root = new TreeNode(1, m1, m2);
        System.out.println(isSymmetric(root));
    }
}
