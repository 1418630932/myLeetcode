package leetcode.middle.test1To200;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-02-19
 * @time 15:06
 **/
public class Test16 {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{0,2,1,-3},1 ));
    }
    public static int threeSumClosest(int[] nums, int target) {
        int minAbs =Integer.MAX_VALUE;
        int res =Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i =0; i <nums.length-2 ; i++) {
            int left = i+1;
            int right = nums.length-1;
            while (left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if (Math.abs(target-sum)<minAbs){
                    minAbs=Math.abs(target-sum);
                    res = sum;
                }
                if (sum-target==0){
                    return target;
                }else if (sum-target>0){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return res;
    }
}
