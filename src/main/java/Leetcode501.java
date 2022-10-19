import java.util.ArrayList;
import java.util.List;

public class Leetcode501 {
    //二叉搜索数众数

    TreeNode pre = null;
    List<Integer> res = new ArrayList<>();
    int count;
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new int[]{root.val};
        }
        helper(root);
        int[] rees = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            rees[i] = res.get(i);
        }
        return rees;
    }

    public void helper(TreeNode cur) {
        if (cur == null) {
            return;
        }
        helper(cur.left);
        if (pre == null) {
            count = 1;
        } else if (pre.val == cur.val) {
            count++;

        } else {
            count = 1;
        }
        if (count == maxCount) {
            res.add(cur.val);
        }
        if (count > maxCount) {
            maxCount = count;
            res = new ArrayList<>();
            res.add(cur.val);
        }
        pre = cur;
        helper(cur.right);
    }
}
