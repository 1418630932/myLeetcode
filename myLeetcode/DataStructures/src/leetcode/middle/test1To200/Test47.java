package leetcode.middle.test1To200;

import java.util.*;

/**
 * @author zhuliyang
 * @date 2020-02-21
 * @time 19:14
 **/
public class Test47 {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,1,2}));
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        boolean[] isVisited = new boolean[nums.length];
        Arrays.sort(nums);
        helper(res, list, isVisited, nums,0);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> list, boolean[] isVisited, int[] nums,int depth) {
        if (depth == nums.length) {
            res.add(new LinkedList<>(list));
        }
        for (int i = 0; i <nums.length ; i++) {
            if (i>0&&nums[i]==nums[i-1]&&isVisited[i-1])continue;
            if (!isVisited[i]){//剪枝
                list.add(nums[i]);
                isVisited[i] =true;
                helper(res, list, isVisited, nums,depth+1);
                list.remove(list.size()-1);//回溯
                isVisited[i] = false;//回溯
            }
        }
    }

}
