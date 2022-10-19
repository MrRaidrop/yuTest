import org.junit.Test;

public class Leetcode80 {
    //删除有序数组中的重复项二

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 2) {
            return len;
        }
        int i = 2, j = 2;
        while (j < len) {
            if (nums[i - 2] != nums[j]) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }

    @Test
    public void test() {
        int[] nums = {0,0,1,1,1,1,1,3,3,3};
        int len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
