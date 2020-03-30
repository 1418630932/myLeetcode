package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-05
 * @time 15:55
 **/
public class Test122 {
    public static void main(String[] args) {
        int i = maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(i);
        int j = maxProfit2(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(j);
    }

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int amount = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                if (prices[i] - min > 0) {//有利可图
                    amount += prices[i] - min;
                    min = prices[i];//当天再次买进
                }
            }
        }
        return amount;
    }


    public static int maxProfit2(int[] prices) {
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
            dp[i][2] = Math.max(dp[i - 1][1] + prices[i], 0);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
    }
}
