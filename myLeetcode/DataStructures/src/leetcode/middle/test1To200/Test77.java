package leetcode.middle.test1To200;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-02-24
 * @time 18:00
 **/
public class Test77 {
    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 3);
        System.out.println(combine);
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        helper(res,temp,n,1,k);
        return res;
    }

    private static void helper(List<List<Integer>> res,  List<Integer> temp,int n,int start, int k ) {
        if (temp.size()==k){
            res.add(new LinkedList<>(temp));
            return;
        }
        for (int i = start; i <=n ; i++) { //i=start 进行去重
                temp.add(i);
                helper(res, temp,n,i+1 ,k );
                temp.remove(temp.size()-1);//回溯
        }
    }
}
