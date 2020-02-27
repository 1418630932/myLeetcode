package leetcode.middle.test1To200;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-02-27
 * @time 13:45
 **/
public class Test93 {
    public static void main(String[] args) {
        List<String> list = restoreIpAddresses("020101");
        System.out.println(list);
    }
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();
        helper(res,s,0,"",0);
        return res;
    }

    private static void helper(List<String> res,String s, int index,String str,int count) {
        if (count>4||index>s.length())return;
        if (index==s.length()&&count==4){
            res.add(str.replaceFirst(".", ""));
            return;
        }
        if (index<s.length()){//一位
            int one = s.charAt(index)-48;
            helper(res,s , index+1,str+"."+one,count+1 );
            if (index+1<s.length()){//两位
                int two = s.charAt(index+1)-48;
                if (one!=0){
                    helper(res,s , index+2,str+"."+one+two ,count+1);
                }
                if (index+2<s.length()){//三位
                    int three = s.charAt(index+2)-48;
                    if (one!=0&&one*100+10*two+three<256){
                        helper(res,s , index+3,str+"."+one+two+three,count+1);
                    }
                }
            }
        }
    }
}
