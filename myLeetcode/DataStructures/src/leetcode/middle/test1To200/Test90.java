package leetcode.middle.test1To200;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-02-25
 * @time 15:48
 **/
public class Test90 {
    public static void main(String[] args) {
        List<List<Integer>> subsets = subsetsWithDup(new int[]{1, 2, 2,2});
        System.out.println(subsets);
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        helper(res,temp,0,nums);
        return res;
    }
    private static void helper(List<List<Integer>> res,  List<Integer> temp,int startIndex,int[] nums ) {
        res.add(new LinkedList<>(temp));
        for (int i = startIndex; i <nums.length ; i++) { //i=start 进行去重
            if (i>startIndex&&nums[i]==nums[i-1])continue;
            temp.add(nums[i]);
            helper(res, temp,i+1 ,nums );
            temp.remove(temp.size()-1);//回溯
        }
    }
}
