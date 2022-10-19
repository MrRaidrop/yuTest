public class Leetcode814 {
    //给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。
    //返回移除了所有不包含 1 的子树的原二叉树。
    //节点 node 的子树为 node 本身加上所有 node 的后代。
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.val == 0 && root.right == null && root.left == null) {
            return null;
        }

        return root;
    }


}
