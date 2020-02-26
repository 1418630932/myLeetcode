package leetcode.middle.test1To200;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-02-26
 * @time 14:10
 **/
public class Test80 {
    public static void main(String[] args) {
        int[] ints = {1,1,1,2,2,3};
        int i = removeDuplicates(ints);
        System.out.println(Arrays.toString(ints));
        System.out.println(i);
    }
    public static int removeDuplicates(int[] nums) {
        int count=1;
        int index =0;
        for(int i=1;i<nums.length;i++){
            if (nums[i]==nums[index]){
                if (count<2){
                    count++;
                    nums[++index]=nums[i];
                }
            }else {
                count=1;
                nums[++index]=nums[i];
            }
        }
        return index+1;
    }
}
