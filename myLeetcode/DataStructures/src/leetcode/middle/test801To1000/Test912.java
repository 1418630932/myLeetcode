package leetcode.middle.test801To1000;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-03-31
 * @time 17:49
 **/
public class Test912 {
    public static void main(String[] args) {
        int[] ints = sortArray(new int[]{2, 4, 5, 1, 2, 3, 45, 1});
        System.out.println(Arrays.toString(ints));
    }

    public static int[] sortArray(int[] nums) {
        quicklySort(0, nums.length - 1, nums);
        return nums;
    }

    private static void quicklySort(int start, int end, int[] nums) {
        if (start>=end){
            return;
        }
        int i = start;
        int j = end;
        int target = nums[start];
        while (i < j) {
            while (i < j && nums[j] >= target) {
                j--;
            }
            while (i < j && nums[i] <= target) {
                i++;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        nums[start] = nums[i];
        nums[i] = target;
        quicklySort(start, i-1, nums);
        quicklySort(j + 1, end, nums);
    }
}
