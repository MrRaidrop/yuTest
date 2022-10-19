import org.junit.Test;

public class Leetcode34 {
    ///给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
    //如果数组中不存在目标值 target，返回 [-1, -1]。
    //你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。

    @Test
    public void test() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] nums2 = {8};
//        int[] res = searchRange(nums, 8);
//        for (int i = 0; i < 2; i++) {
//            System.out.println(res[i]);
//        }
        int[] res2 = searchRange(nums2, 8);

        for (int i = 0; i < 2; i++) {
            System.out.println(res2[i]);
        }
    }

    private int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int res = -2;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] >= target) {
                right = mid - 1;
                res = right;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    private int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int res = -2;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
                res = left;
            }
        }
        return res;
    }


    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums.length == 0 || target > nums[nums.length - 1] || target < nums[0]) {
            return res;
        }
        int left = findLeft(nums, target);
        int right = findRight(nums, target);
        if (left == -2 || right == -2) {
            return res;
        }
        if (right - left > 1) {
            return new int[]{left + 1, right - 1};
        }
        return res;
    }


}
