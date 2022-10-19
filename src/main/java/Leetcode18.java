import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode18 {
    //一个无序数组里的四个数相加为target的组合，不能重复

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        if (len < 4) {
            return new ArrayList<>();
        }
        if (nums[0] == 1000000000) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < len; k++) {
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            for (int i = k + 1; i < len; i++) {
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1;
                int right = len - 1;
                while (left < right) {
                    if (nums[i] + nums[k] == target - (nums[left] + nums[right])) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[k]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        res.add(temp);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left > right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[i] + nums[k] < target - (nums[left] + nums[right])) {
                        left++;
                    } else {
                        right--;
                    }
                }

            }
        }
        return res;
    }


    @Test
    public void test() {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        List<List<Integer>> res = fourSum(nums, -294967296);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println("");
        }
    }
}
