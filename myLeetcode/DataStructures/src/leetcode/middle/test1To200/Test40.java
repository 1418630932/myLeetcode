package leetcode.middle.test1To200;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-02-21
 * @time 15:55
 **/
public class Test40 {
    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum2(new int[]{2,5,2,1,2}, 5);
        System.out.println(lists);
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);//为了剪枝一定要排序
        List<Integer> list = new LinkedList<>();
        helper(res,candidates,target,list,0);
        return res;
    }
    public static void helper(List<List<Integer>> res, int[] candidates, int target, List<Integer> list,int index){
        if (target<0)return;
        if (target==0){
            res.add(new LinkedList<>(list));//java引用传递 需要拷贝一份对象出来
            return;
        }
        for (int i = index; i <candidates.length ; i++) {
            if (i>index&&candidates[i]==candidates[i-1])continue;//和起点重复
            list.add(candidates[i]);
            helper(res,candidates ,target-candidates[i] ,list, i+1);//把 index+1传过去是为了剪枝
            list.remove(list.size()-1);//回溯
        }
    }
}
