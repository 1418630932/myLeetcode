package leetcode.easy.test1To200;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-01-31
 * @time 18:21
 **/
public class Test26 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
    public static int removeDuplicates(int[] nums) {
        int index =0;
        for (int i = 1; i <nums.length ; i++) {
            if (nums[index]!=nums[i]) {
                nums[++index] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return index+1;
    }
}
