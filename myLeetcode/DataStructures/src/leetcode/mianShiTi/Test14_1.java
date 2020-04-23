package leetcode.mianShiTi;

/**
 * @author zhuliyang
 * @date 2020-04-19
 * @time 14:36
 **/
public class Test14_1 {
    public static void main(String[] args) {
        int i = cuttingRope(12);
        System.out.println(i);
    }
    public static int cuttingRope(int n) {
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for (int i = 3; i <=n ; i++) {
            int max = -1;
            for (int j = 1; j <i ; j++) {
                int remain = i-j;
                max = Math.max(max,j*Math.max(dp[i-j],remain) );
            }
            dp[i] =max;
        }
        return dp[n];
    }
}
