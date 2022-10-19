import java.util.ArrayList;
import java.util.List;

public class Leetcode257 {
    //给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        List<TreeNode> path = new ArrayList<>();
        helper(root,path);
        return res;
    }

    private void helper(TreeNode cur, List<TreeNode> path) {
        path.add(cur);
        if (cur.left == null && cur.right == null) {
            res.add(pathToString(path));
        }
        if (cur.left!=null) {
            helper(cur.left, path);
            path.remove(path.size()-1);
        }
        if(cur.right!=null) {
            helper(cur.right, path);
            path.remove(path.size()-1);
        }

    }

    private String pathToString(List<TreeNode> path) {
        String res = "" + path.get(0).val;
        for (int i = 1; i < path.size(); i++) {
            res += "->" + path.get(i).val;
        }
        return res;
    }

}
