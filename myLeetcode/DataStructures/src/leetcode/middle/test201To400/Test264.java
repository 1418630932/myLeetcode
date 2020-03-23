package leetcode.middle.test201To400;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhuliyang
 * @date 2020-03-23
 * @time 17:08
 **/
public class Test264 {
    public static void main(String[] args) {
        int i = nthUglyNumber(10);
        System.out.println(i);
    }
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        for (int i = 1; i <dp.length ; i++) {
            int value1 = dp[p1]*2;
            int value2 = dp[p2]*3;
            int value3 = dp[p3]*5;
            dp[i] = Math.min(value1,Math.min(value2,value3 ));
            if (dp[i]==value1)p1++;
            if (dp[i]==value2)p2++;
            if (dp[i]==value3)p3++;
        }
        return dp[dp.length-1];
    }
}
