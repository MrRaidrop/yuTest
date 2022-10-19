import org.junit.Test;

public class Leetcode27 {
    //给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

    public int removeElement(int[] nums, int val) {
        int len  = nums.length;
        if (len == 0) {
            return 0;
        }
        int i = 0, j = 0;
        while (j < len) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }

    @Test
    public void test() {
        int[] nums = {0,1,2,2,3,0,4,2};
        int len = removeElement(nums, 2);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
