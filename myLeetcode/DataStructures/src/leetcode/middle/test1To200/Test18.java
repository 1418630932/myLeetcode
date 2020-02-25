package leetcode.middle.test1To200;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-02-19
 * @time 17:24
 **/
public class Test18 {
    public static void main(String[] args) {
        fourSum(new int[]{-1,-5,-5,-3,2,5,0,4}, -7);
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums==null||nums.length<4)return res;
        Arrays.sort(nums);
        for (int i = 0; i <nums.length-3 ; i++) {
            if (i>0&&nums[i]==nums[i-1])continue;
            for (int j = i+1; j <nums.length-2 ; j++) {
                if (j-1!=i&&nums[j]==nums[j-1])continue;
                int left =j+1;
                int right = nums.length-1;
                while (left<right){
                    if (nums[i]+nums[j]+nums[left]+nums[right]>target){
                        right--;
                    }else if (nums[i]+nums[j]+nums[left]+nums[right]<target){
                        left++;
                    }else {
                        res.add(new LinkedList<>(Arrays.asList(nums[i],nums[j],nums[left],nums[right])));
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

        }
        return res;
    }
}
