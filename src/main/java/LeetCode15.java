import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//用双指针和排序求一个数组中三个数加起来为0的数组

public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if (nums == null || n < 3) {
            return null;
        }
        quickSort(nums, 0, n - 1);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k){
                if (nums[j] + nums[k] + nums[i] == 0) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    res.add(temp);
                    while (j < k && nums[j] == nums[j +1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                    continue;
                }
                if (nums[j] + nums[k] + nums[i] < 0) {

                    j++;
                    continue;
                }
                if (nums[j] + nums[k] + nums[i] > 0) {

                    k--;
                }
            }


        }
        return res;
    }

    public static void quickSort(int[] arr, int low, int high) {
        int p, i, j, temp;

        if (low >= high) {
            return;
        }
        p = arr[low];
        i = low;
        j = high;
        while (i < j) {
            while (arr[j] >= p && i < j) {
                j--;
            }
            while (arr[i] <= p && i < j) {
                i++;
            }
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        arr[low] = arr[i];
        arr[i] = p;
        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);
    }



    @Test
    public void main() {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[]{3,0,-2,-1,1,2};
        res = threeSum(nums);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println("");
        }
    }
}
