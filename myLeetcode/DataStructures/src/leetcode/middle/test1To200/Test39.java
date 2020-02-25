package leetcode.middle.test1To200;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-02-21
 * @time 14:48
 **/
public class Test39 {
    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum(new int[]{1,2}, 4);
        System.out.println(lists);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);//为了剪枝一定要排序
        List<Integer> list = new LinkedList<>();
        helper(res,candidates,target,list,candidates[0]);
        return res;
    }
    public static void helper(List<List<Integer>> res, int[] candidates, int target, List<Integer> list,int num){
        if (target<0)return;
        if (target==0){
            res.add(new LinkedList<>(list));//java引用传递 需要拷贝一份对象出来
            return;
        }
        for (int candidate : candidates) {
            if (candidate>=num){//剪枝
                list.add(candidate);
                helper(res,candidates ,target-candidate ,list, candidate);//把 candidate传过去是为了剪枝
                list.remove(list.size()-1);//回溯
            }
        }
    }
}