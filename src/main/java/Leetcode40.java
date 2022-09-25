import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode40 {

    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        helper(candidates, target, 0, 0);
        Arrays.sort(candidates);
        return res;
    }

    private void helper(int[] nums, int target, int cur, int start) {
        if (cur == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (cur + nums[i] > target) {
                break;
            }
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            helper(nums, target, cur + nums[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    @Test
    public void test() {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> tttt = combinationSum2(candidates, 8);
        for (int i = 0; i < tttt.size(); i++) {
            for (int j = 0; j < tttt.get(i).size(); j++) {
                System.out.print(tttt.get(i).get(j) + " ");
            }
            System.out.println("");
        }
    }
}
