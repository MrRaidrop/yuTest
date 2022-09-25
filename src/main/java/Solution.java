// leetcode 27

import org.testng.annotations.Test;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0, j = nums.length; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                nums[j] = val;
                count++;
                j--;
            }
        }
        return nums.length - count;
    }

    @Test
    public void test(String[] args) {
        int[] nums = new int[] {3,2,2,3};
        int val = 3;
        System.out.println();
    }
}
