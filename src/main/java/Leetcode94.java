import java.util.ArrayList;
import java.util.List;

public class Leetcode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        List<TreeNode> q = new ArrayList<>();
        TreeNode cur = root;
        while (!q.isEmpty()||cur!=null) {
            if (cur != null) {
                q.add(cur);
                cur = cur.left;
            } else {
                cur = q.remove(q.size() - 1);
                res.add(cur.val);
                cur=cur.right;
            }
        }
        return res;
    }
}
