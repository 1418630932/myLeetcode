package leetcode.middle.test601To800;

/**
 * @author zhuliyang
 * @date 2020-03-29
 * @time 17:23
 **/
public class Test714 {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[prices.length][3];
        // 在第i天所能获得的最大利润
        dp[0][0] = 0;//当天未持有股票的利润
        dp[0][1] = -prices[0];//当天买入股票时的利润
        dp[0][2] = 0;//当天卖出股票时的利润
        for (int i = 1; i < prices.length; i++) {
            //今天继续不买股票||昨天卖出股票
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][2]);
            //昨天不持股今天买入股票 ||继续持有股票||昨天卖出||今日买入
            dp[i][1] = Math.max(Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]),dp[i-1][2] - prices[i]);
            //今天卖出股票
            dp[i][2] = Math.max(dp[i - 1][1] + prices[i]-fee, 0);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
    }
}
