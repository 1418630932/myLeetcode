package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-06
 * @time 16:40
 **/
public class Test168 {
    public static void main(String[] args) {
        System.out.println(convertToTitle(27));
    }
    public static String convertToTitle(int n) {
        StringBuffer res = new StringBuffer();
        while (n>0){
            int tail = n%26==0?26:n%26;
            n=(n-tail)/26;
            res.append((char)(tail+64));
        }
        return res.reverse().toString();
    }
}
