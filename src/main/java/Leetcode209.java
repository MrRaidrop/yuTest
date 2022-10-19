import org.junit.Test;

public class Leetcode209 {
    //给定一个含有 n 个正整数的数组和一个正整数 target 。
    //找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
    // 并返回其长度。如果不存在符合条件的子数组，返回 0 。

    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0;
        int len = nums.length;
        int sum = 0;
        int res = 999999;
        for (j = 0; j < len; j++) {
            sum += nums[j];
            while (sum >= target) {
                res = Math.min(j-i+1, res);
                sum -= nums[i];
                i++;
            }
        }
        if (res == 999999) {
            return 0;
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {1,2,3,4,5};
        int len = minSubArrayLen(15, nums);
        System.out.println(len);
//        for (int i = 0; i < len; i++) {
//            System.out.println(nums[i]);
//        }
    }

}
