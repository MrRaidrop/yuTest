
public class Leetcode110 {
    //给定一个二叉树，判断它是否是高度平衡的二叉树。
    //本题中，一棵高度平衡二叉树定义为：
    //一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
    int res = 0;

    public boolean isBalanced(TreeNode root) {
        preOrder(root);
        return res == 0;
    }

    private int preOrder(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int l = 1 + preOrder(cur.left);
        int r = 1 + preOrder(cur.right);
        if (Math.abs(l - r) > 1) {
            res += 1;
        }
        return Math.max(l, r);
    }
}
