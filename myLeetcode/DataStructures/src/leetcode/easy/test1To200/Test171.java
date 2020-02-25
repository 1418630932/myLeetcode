package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-07
 * @time 15:01
 **/
public class Test171 {
    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
        System.out.println('A'+0);
    }
    public static int titleToNumber(String s) {
        int res =0;
        for (int i =0; i <s.length() ; i++) {
            res +=(s.charAt(i)-64)*Math.pow(26,s.length()-i-1);
        }
        return res;
    }
}
