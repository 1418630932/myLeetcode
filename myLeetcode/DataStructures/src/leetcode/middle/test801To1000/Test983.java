package leetcode.middle.test801To1000;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-05-06
 * @time 0:30
 **/
public class Test983 {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[396];
        int index =0;
        for (int i = 31; i <dp.length ; i++) {
            if(index==days.length)return dp[i-1];
            //今天需不需要旅游？
            if (i-30<days[index]){
                //不旅游不花钱
                dp[i] = dp[i-1];
            }else {
                //要旅游取最优
                index++;
                dp[i] = Math.min(dp[i-1]+costs[0],Math.min(dp[i-7]+costs[1],dp[i-30]+costs[2]));
            }
        }
        return dp[dp.length-1];
    }
}
