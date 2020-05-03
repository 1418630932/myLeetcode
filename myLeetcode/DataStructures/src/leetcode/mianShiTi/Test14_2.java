package leetcode.mianShiTi;

/**
 * @author zhuliyang
 * @date 2020-04-19
 * @time 14:53
 **/
public class Test14_2 {
    public static void main(String[] args) {
        int i=1;
        int b= 0;
        int c=b=i;
        System.out.println(c);
        System.out.println(b);
    }

    public static int cuttingRope(int n) {
        long[] dp = new long[n+1];
        dp[1] =1;
        dp[2] =1 ;
        dp[3] =2 ;
        dp[4] =4 ;
        dp[5] =6 ;
        dp[6] =9 ;
        for (int i = 7; i <=n ; i++) {
            dp[i] = (dp[i-3]*3)%1000000007;
        }
        return (int) dp[n];
    }
}
