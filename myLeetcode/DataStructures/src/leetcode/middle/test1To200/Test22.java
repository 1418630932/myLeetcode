package leetcode.middle.test1To200;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-02-19
 * @time 20:00
 **/
public class Test22 {
    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        System.out.println(list);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        helper(res,0 ,0 , n,"" );
        return res;
    }
    public static void helper(List<String> res,int left ,int right,int n,String str ){
        if (right>left||left>n)return;
        if (left+right==2*n&&left==right){
            res.add(str);
            return;
        }
        helper(res,left+1 ,right ,n ,str+"(" );
        helper(res,left ,right+1 ,n ,str+")" );
    }
}
