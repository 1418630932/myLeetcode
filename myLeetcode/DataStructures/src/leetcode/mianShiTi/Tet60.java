package leetcode.mianShiTi;

/**
 * @author zhuliyang
 * @date 2020-04-06
 * @time 15:59
 **/
public class Tet60 {
    public double[] twoSum(int n) {
        double[] dp = new double[n*6-n-1];
        double total = Math.pow(6, n);
        int i=0;
        int j=dp.length-1;
        dp[i++]=1.0/total;
        dp[j--]=1.0/total;
        while (i<j){
            dp[i]=dp[i-1]+dp[0]*(n-1);
            dp[j]=dp[j+1]+dp[0]*(n-1);
            i++;
            j--;
        }
        return dp;
    }
}
