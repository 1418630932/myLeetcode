package leetcode.middle.test1To200;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-02-20
 * @time 14:44
 **/
public class Test31 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void nextPermutation(int[] nums) {
        if (nums==null||nums.length<2)return;
        boolean falg = true; //倒序升序排列的标志
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i-1]<nums[i]){//倒序升序被破坏
                falg = false;
                int index = i-1;
                int start = i;
                while (start<nums.length&&nums[index]<nums[start]){//找到大于num[index] 且最小的那个数
                    start++;
                }
                int temp = nums[index];
                nums[index] = nums[start-1];
                nums[start-1]=temp;
                Arrays.sort(nums,i,nums.length);
                break;
            }
        }
        if (falg){//如果数组是倒序升序
            Arrays.sort(nums);
        }
    }
}
