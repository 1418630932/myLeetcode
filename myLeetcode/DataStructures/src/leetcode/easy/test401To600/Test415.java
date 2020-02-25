package leetcode.easy.test401To600;

/**
 * @author zhuliyang
 * @date 2020-02-13
 * @time 16:21
 **/
public class Test415 {
    public String addStrings(String num1, String num2) {
        int add =0;
        int i = num1.length()-1;
        int j = num2.length()-1;
        String res = "";
        while(i>=0||j>=0){
            int sum = add;
            if (i>=0){
                sum+=num1.charAt(i)-'0';
            }
            if (j>=0){
                sum+=num2.charAt(j)-'0';
            }
            add = sum/10;
            int tail = sum%10;
            res = tail+res;
            i--;
            j--;
        }
        return add==0?res:add+res;
    }
}
