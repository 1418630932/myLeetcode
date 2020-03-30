package leetcode.middle.test201To400;

import java.util.Map;

/**
 * @author zhuliyang
 * @date 2020-03-29
 * @time 15:12
 **/
public class Test309 {
    public int maxProfit(int[] prices) {
        if(prices.length==0)return 0;
        int[][] dp = new int[prices.length][3];
        // 在第i天所能获得的最大利润
        dp[0][0]=0;//未持有股票的利润
        dp[0][1]=-prices[0];//买入股票时的利润
        dp[0][2]=0;//卖出股票时的利润
        for (int i = 1; i <prices.length ; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2] );//继续不买股票||昨天卖出股票的最大利润
            dp[i][1] = Math.max(dp[i-1][0]-prices[i],dp[i-1][1] );//今天买入股票 ||继续持有股票
            dp[i][2] = Math.max(dp[i-1][1]+prices[i],0);//今天卖出股票
        }
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][2] );
    }
}
