package leetcode.middle.test201To400;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-02-15
 * @time 22:35
 **/
public class Test322 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5}, 31));
    }
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1 );
        for(int coin: coins){
            if(coin<amount){
                dp[coin]=1; //组成coin块钱时只要一个硬币
            }
        }
        for(int i=1;i<amount+1;i++){
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0){
                    dp[i] = Math.min(dp[i-coins[j]]+1,dp[i]); //组成i块钱时最少需要几个硬币
                }
            }
        }
        return dp[amount]>=amount?-1:dp[amount];
    }
}
