package leetcode.middle.test1To200;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-02-18
 * @time 21:16
 **/
public class Test15 {
    public static void main(String[] args) {
        threeSum(new int[]{-1,0,1,2,-1,-4});
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums==null||nums.length<3)return res;
        Arrays.sort(nums);
        for (int i = 0; i <nums.length ; i++) {
            if (i>1&&nums[i]==nums[i-1])continue;
            if (nums[i]>0)return res;
            int left =i+1;
            int right = nums.length-1;
            while (left<right){
                if (nums[i]+nums[left]+nums[right]>0){
                    right--;
                }else if (nums[i]+nums[left]+nums[right]<0){
                    left++;
                }else {
                    res.add(new LinkedList<>(Arrays.asList(nums[i],nums[left],nums[right])));
                    left++;
                    right--;
                    while (left<right&&nums[left]==nums[left-1]){
                        left++;
                    }
                    while (left<right&&nums[right]==nums[right+1]){
                        right--;
                    }
                }
            }
        }
        return res;
    }

}
