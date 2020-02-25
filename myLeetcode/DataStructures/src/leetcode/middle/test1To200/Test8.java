package leetcode.middle.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-18
 * @time 17:45
 **/
public class Test8 {
    public static void main(String[] args) {
        myAtoi("42");
    }
    public static int myAtoi(String str) {
        if (str==null||str.length()==0)return 0;
        String trim = str.trim();//去除前置空格
        if (trim.length()==0)return 0;
        int res =0;
        int target =1;
        //第一位做判断
        if (trim.charAt(0)=='+'){
            target=1;
        }else if (trim.charAt(0)=='-'){
            target=-1;
        }else if (isNumber(trim.charAt(0))){
            res = trim.charAt(0)-'0';
        }else {
            return 0;
        }

        for (int i = 1; i <trim.length() ; i++) {
           if (isNumber(trim.charAt(i))){
               if (res>=0){
                   if (res<=Integer.MAX_VALUE/10){
                       if ((trim.charAt(i)-'0')>7&&res==Integer.MAX_VALUE/10){
                           return Integer.MAX_VALUE;
                       }else {
                           res = res*10+(trim.charAt(i)-'0')*target;
                       }
                   }else {
                       return Integer.MAX_VALUE;
                   }
               }else {
                   if (res>=Integer.MIN_VALUE/10){
                       if ((trim.charAt(i)-'0')>8&&res==Integer.MIN_VALUE/10){
                           return Integer.MIN_VALUE;
                       }else {
                           res = res*10+(trim.charAt(i)-'0')*target;
                       }
                       continue;
                   }else {
                       return Integer.MIN_VALUE;
                   }
               }
           }else {
               return res;
           }
        }
        return res;
    }
    public static boolean isNumber(char ch){
        return ch>='0'&&ch<='9';
    }
}
