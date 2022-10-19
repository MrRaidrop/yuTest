public class Leetcode1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode res = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            res = add(res, preorder[i]);
        }
        return res;
    }

    TreeNode add(TreeNode cur, int num) {
        if (cur == null) {
            return new TreeNode(num);
        }
        if (num<cur.val) {
            cur.left = add(cur.left, num);
        } else {
            cur.right = add(cur.right, num);
        }
        return cur;
    }
}
