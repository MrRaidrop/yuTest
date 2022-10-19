import java.util.ArrayList;
import java.util.List;

public class Leetcode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<TreeNode> que = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root!=null) {
            que.add(root);
        }
        TreeNode cur;
        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                cur = que.get(0);
                que.remove(0);
                temp.add(cur.val);
                if (cur.left!=null) {
                    que.add(cur.left);
                }
                if (cur.right!=null) {
                    que.add(cur.right);
                }
            }
            res.add(new ArrayList<>(temp));
        }
        return res;
    }
}
