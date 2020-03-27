package leetcode.middle.test201To400;

/**
 * @author zhuliyang
 * @date 2020-03-26
 * @time 10:09
 **/
public class Test279 {
    public static void main(String[] args) {
        int i = numSquares(12);
        System.out.println(i);
    }
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0]=0;
        for (int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1;j*j<=i ; j++) {
                int remain =i-j*j;
                min = Math.min(min,dp[remain]+1);
            }
            dp[i] = min;
        }
        return dp[dp.length-1];
    }
}
