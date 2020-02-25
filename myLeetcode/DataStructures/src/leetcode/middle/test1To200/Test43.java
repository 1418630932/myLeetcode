package leetcode.middle.test1To200;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-02-21
 * @time 16:46
 **/
public class Test43 {
    public static void main(String[] args) {
        String multiply = multiply("123", "456");
        System.out.println(multiply);
    }
    public static String multiply(String num1, String num2) {
        if (num1.equals("0")||num2.equals("0"))return "0";
        int[] res = new int[num1.length()+num2.length()];
        for (int i = num1.length()-1; i >=0 ; i--) {
            for (int j = num2.length()-1; j >=0 ; j--) {
                int a = num1.charAt(i)-'0';
                int b = num2.charAt(j)-'0';
                int carry = a*b+res[i+j+1];
                res[i+j+1]=carry%10;
                res[i+j]=res[i+j]+carry/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i <res.length ; i++) {
            if (res[i]!=0){
                flag = true;
            }
            if (flag){
                sb.append(res[i]);
            }
        }
        return sb.toString();
    }
}
