import org.testng.annotations.Test;

public class Leetcode124 {
    private int sum = (int)-Math.pow(2, 16);
    public int maxPathSum(TreeNode root) {
        int newSum = helper(root);
        return Math.max(sum, newSum);
    }
    private int helper(TreeNode cur) {
        if (cur == null ){
            return 0;
        }
        int left = helper(cur.left);
        int right = helper(cur.right);
        int condition1 = cur.val;
        int condition2 = cur.val+left;
        int condition3 = cur.val+right;
        int condition4 = left;
        int condition5 = right;
        int condition6 = condition1+condition5+condition4;
        sum = Math.max(Math.max(sum, condition6),Math.max(condition4,condition5));
        return Math.max(condition1, Math.max(condition2,condition3));
    }

    @Test
    public void test() {
        TreeNode cr = new TreeNode(-3);
        System.out.println(maxPathSum(cr));
    }
}
