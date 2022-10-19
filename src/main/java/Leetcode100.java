
public class Leetcode100 {
    //两个树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return midOrder(p, q) + preOrder(p, q) + backOrder(p, q) == 0;
    }

    private int midOrder(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return 0;
        } else if ((p == null && q != null) || (q == null && p != null)) {
            return -1;
        }
        int left = midOrder(p.left, q.left);
        int cur = p.val == q.val ? 0 : -1;
        int right = midOrder(p.right, q.right);
        return left + cur + right;
    }

    private int preOrder(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return 0;
        } else if ((p == null && q != null) || (q == null && p != null)) {
            return -1;
        }
        int cur = p.val == q.val ? 0 : -1;
        int left = preOrder(p.left, q.left);
        int right = preOrder(p.right, q.right);
        return left + cur + right;
    }

    private int backOrder(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return 0;
        } else if ((p == null && q != null) || (q == null && p != null)) {
            return -1;
        }
        int cur = p.val == q.val ? 0 : -1;
        int left = backOrder(p.left, q.left);
        int right = backOrder(p.right, q.right);
        return left + cur + right;
    }

}
