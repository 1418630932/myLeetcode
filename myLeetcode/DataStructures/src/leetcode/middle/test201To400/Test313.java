package leetcode.middle.test201To400;

/**
 * @author zhuliyang
 * @date 2020-03-23
 * @time 20:27
 **/
public class Test313 {
    public static void main(String[] args) {
        int i = nthSuperUglyNumber(12, new int[]{2, 7, 13, 19});
        System.out.println(i);
    }
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        int[] points = new int[primes.length];
        dp[0]=1;
        for (int i = 1; i <dp.length ; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j <primes.length ; j++) {
                min = Math.min(min,dp[points[j]]* primes[j]);
            }
            dp[i] =min;
            for (int j = 0; j < points.length; j++) {
                if (dp[points[j]]* primes[j]==min)points[j]++;
            }
        }
        return dp[dp.length-1];
    }
}
