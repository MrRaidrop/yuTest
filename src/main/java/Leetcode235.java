public class Leetcode235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root!=null) {
            if (root.val> p.val&&root.val>q.val) {
                root = lowestCommonAncestor(root.left,new TreeNode(p.val),new TreeNode(q.val));
            }
            if (root.val< p.val&&root.val<q.val) {
                root = lowestCommonAncestor(root.right,new TreeNode(p.val),new TreeNode(q.val));
            }
            return root;
        }
        return null;
    }
}
