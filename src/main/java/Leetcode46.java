import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Leetcode46 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    @Test
    public void test() {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> res2 = permute(nums);
        for (int i = 0; i < res2.size(); i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(res2.get(i).get(j)+" ");
            }
            System.out.println("");
        }
    }

    //给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
    public List<List<Integer>> permute(int[] nums) {
        int k = nums.length;
        boolean[] used = new boolean[k];
        helper(nums, used);
        return res;

    }

    public void helper(int[] nums, boolean[] used) {
        if (nums.length == temp.size()) {
            res.add(new ArrayList<>(temp));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                temp.add(nums[i]);
                used[i] = true;
                helper(nums, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }
}
