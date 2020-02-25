package leetcode.easy.test401To600;

/**
 * @author zhuliyang
 * @date 2020-02-15
 * @time 18:42
 **/
public class Test459 {
    public static void main(String[] args) {
        repeatedSubstringPattern("abab");
    }
    public static boolean repeatedSubstringPattern(String s) {
        String ds = s+s;
        return ds.substring(1,ds.length()-1 ).contains(s);
    }
}
