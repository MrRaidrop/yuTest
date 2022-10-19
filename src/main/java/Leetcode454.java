import org.junit.Test;

import java.util.HashMap;

public class Leetcode454 {
    //四个数组里每个抽一个数字看看有多少加起来为t的

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> temp = new HashMap<>();
        int cur, count = 0;
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                cur = n1 + n2;
                if (temp.containsKey(cur)) {
                    temp.put(cur, temp.get(cur) + 1);
                } else {
                    temp.put(cur, 1);
                }
            }
        }
        for (int n3 : nums3) {
            for (int n4 : nums4) {
                cur = -n3 - n4;
                if (temp.containsKey(cur)) {
                    count += temp.get(cur);
                }
            }
        }
        return count;
    }

    @Test
    public void test() {
        int[] nums1 = {-1, -1};
        int[] nums2 = {-1, 1};
        int[] nums3 = {-1, 1};
        int[] nums4 = {1, -1};
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }
}
