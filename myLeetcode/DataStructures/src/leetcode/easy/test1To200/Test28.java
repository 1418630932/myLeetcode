package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-01-31
 * @time 19:08
 **/
public class Test28 {
    public static void main(String[] args) {
        System.out.println(strStr("",  "pi"));
    }
    public  static  int strStr(String haystack, String needle) {
        for (int i = 0; i <=haystack.length()-needle.length() ; i++) {
            if (needle.equals(haystack.substring(i, i+needle.length()))){
                return i;
            }
        }
        return  -1;
    }
}
