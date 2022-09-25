import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode56 {
    //以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi]。
    // 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        int[][] nums = sort(intervals);
        ArrayList<int[]> temp = new ArrayList<>();
        temp.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i][0] <= temp.get(temp.size() - 1)[1]
                    && nums[i][0] >= temp.get(temp.size() - 1)[0]
                    && nums[i][1] > temp.get(temp.size() - 1)[1]) {
                int[] cur = new int[]{temp.get(temp.size() - 1)[0], nums[i][1]};
                temp.set(temp.size()- 1, cur);
            }else if (nums[i][0] >= temp.get(temp.size() - 1)[0]
                    && nums[i][1] <= temp.get(temp.size() - 1)[1]) {
                continue;
            } else {
                temp.add(nums[i]);
            }
        }
        int[][] res = new int[temp.size()][2];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }
        return res;
    }


    public int[][] sort(int[][] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[][] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return quickSort(arr, 0, arr.length - 1);
    }

    private int[][] quickSort(int[][] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partition(int[][] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i][0] < arr[pivot][0]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    @Test
    public void test() throws Exception {
        int[][] nums = new int[][]{{9, 32}, {8, 10}, {2, 6}, {1, 8}};
        int[][] res = merge(nums);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println("");
        }

    }

}
