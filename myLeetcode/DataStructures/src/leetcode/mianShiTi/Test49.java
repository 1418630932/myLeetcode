package leetcode.mianShiTi;

/**
 * @author zhuliyang
 * @date 2020-04-06
 * @time 15:24
 **/
public class Test49 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0]=1;
        int p1 =0;
        int p2 =0;
        int p3 =0;
        for (int i = 2; i <n ; i++) {
            int value1 = dp[p1]*2;
            int value2 = dp[p2]*3;
            int value3 = dp[p3]*5;
            dp[i] = Math.max(value1, Math.max(value2,value3 ));
            if (dp[i]==value1)p1++;
            if (dp[i]==value2)p2++;
            if (dp[i]==value3)p3++;
        }
        return dp[n-1];
    }
}
