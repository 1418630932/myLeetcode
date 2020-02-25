package leetcode.middle.test1To200;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-02-24
 * @time 16:29
 **/
public class Test75 {
    public static void main(String[] args) {
        int[] arr = {2,0,2,2,1,0,0,2,1,1,1,0};
        sortColors1(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }
        int index = 0;
        for (int i = 0; i <count.length ; i++) {
            while (count[i]!=0){
                nums[index++]=i;
                count[i]--;
            }
        }
    }


    public static void sortColors1(int[] nums) {
        int index =0;
        int start =0;
        int end = nums.length-1;
        while (index<=end){
            if (nums[index]==0){
                int temp = nums[start];
                nums[start++]=nums[index];
                nums[index++]=temp;
            }else if (nums[index]==2){
                int temp = nums[end];
                nums[end--]=nums[index];
                nums[index]=temp;
            }else {
                index++;
            }
        }
    }
}
