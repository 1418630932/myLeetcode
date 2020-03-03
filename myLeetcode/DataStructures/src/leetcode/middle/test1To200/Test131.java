package leetcode.middle.test1To200;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-03-02
 * @time 14:47
 **/
public class Test131 {
    public static void main(String[] args) {
        List<List<String>> aab = partition("abbba");
        System.out.println(aab);
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        List<String> list = new LinkedList<>();
        helper(res,list,s,0);
        return res;
    }

    private static void helper(List<List<String>> res, List<String> list, String s, int index) {
        if (index==s.length()){
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = index+1; i <=s.length() ; i++) {
            String substring = s.substring(index, i);
            if (isPartition(substring)){
                list.add(substring);
                helper(res,list , s,i );
                    list.remove(list.size()-1);//回溯
            }
        }
    }
    //判断是否为回文串
    private static boolean isPartition(String s){
        char[] chars = s.toCharArray();
        int i =0;
        int j = s.length()-1;
        while (i<j){
            if (chars[i]!=chars[j])return false;
            i++;
            j--;
        }
        return true;
    }
}
