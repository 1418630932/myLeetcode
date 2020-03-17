package leetcode.middle.test201To400;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-03-16
 * @time 17:25
 **/
public class Test216 {
    public static void main(String[] args) {
        List<List<Integer>> list = combinationSum3(4, 24);
        System.out.println(list);
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i =1; i <=9 ; i++) {
            list.add(i);
            helper(res,list,i,n-i,k);
            list.remove(list.size()-1);
        }
        return res;
    }

    private static void helper(List<List<Integer>> res, LinkedList<Integer> list, int start, int n,int size) {
        if (n==0&&list.size()==size){
            res.add(new ArrayList<>(list));
        }
        for (int i = start+1; i <=9 ; i++) {
            list.add(i);
            if (list.size()<=size&&n-i>=0){
                helper(res, list, i, n-i, size);
            }
            list.remove(list.size()-1);
        }
    }
}
