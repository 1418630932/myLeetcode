package leetcode.middle.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-26
 * @time 18:59
 **/
public class Test91 {
    public static void main(String[] args) {
        int i = numDecodings("225822");
        System.out.println(i);
    }
    public static int numDecodings(String s) {
        if(s.length() == 0) return 0;
        if(s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()+1];
        dp[0]=1;//第一位
        for (int i = 1; i <s.length() ; i++) {
            int ge =s.charAt(i)-48;
            int shi =s.charAt(i-1)-48;
            if (ge<=9&&ge>=1){//1~9
                dp[i] += dp[i-1];//符合就转换为跳台阶问题
            }
            int num = shi*10+ge;
            if (num>=10&&num<=26) { //10~26
                dp[i]+=i==1?1:dp[i - 2];//如果是第一个两位就加一 ，否则就跳台阶
            }
        }
        return dp[s.length()-1];
    }
}
