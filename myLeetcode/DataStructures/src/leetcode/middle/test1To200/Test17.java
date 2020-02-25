package leetcode.middle.test1To200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-02-19
 * @time 15:48
 **/
public class Test17 {
    public static void main(String[] args) {
        List<String> list = letterCombinations("23");
        System.out.println(list);
    }
    public static List<String> letterCombinations(String digits) {
        if (digits==null||digits.length()==0)return null;
        String[] table = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new LinkedList<>();
        helper(res,table ,digits ,"" ,0 );
        return res;
    }
    public static void helper(List<String> res,String[] table,String digits,String str,int depth){
        if (depth==digits.length()){
            res .add(str);
            return;
        }
        int index  =digits.charAt(depth)-'2';
        for (int i = 0; i <table[index].length() ; i++) {
            helper(res,table ,digits ,str+table[index].charAt(i) ,depth+1 );
        }
    }
}
