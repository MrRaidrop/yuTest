import org.junit.Test;
//二分法的边界问题要处理好，这个东西最烦的就是+1-1,最好直接记住
public class Leetcode35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + ((right - left) / 2);
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
            if (nums[mid] == target) {
                return mid;
            }
        }
        return right + 1;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 3, 5, 6};
        int res = searchInsert(nums, 0);
        System.out.println(res);
    }
}
