package leetcode.middle.test1To200;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author zhuliyang
 * @date 2020-02-21
 * @time 18:21
 **/
public class Test46 {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        helper(res, list, set, nums);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> list, Set<Integer> set, int[] nums) {
        if (set.size() == nums.length) {
            res.add(new LinkedList<>(list));
        }
        for (int num : nums) {
            if (!set.contains(num)) {//剪枝
                set.add(num);
                list.add(num);
                helper(res, list, set, nums);
                set.remove(num);//回溯
                list.remove(list.size() - 1);//回溯
            }
        }
    }
}
