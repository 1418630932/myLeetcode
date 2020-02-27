package leetcode.middle.test1To200;

import leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-02-27
 * @time 15:54
 **/
public class Test96 {
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
    public static int numTrees(int n) {
        //dp[n] = n个数时代表的个数总和 = f(1)+f(2)+f(3)+...+f(n)
        // f（t）代表 t为根的数的总和   1<=t<=n
        //f(t)的左子树有 t-1个数构成 有dp(t-1)种可能   f(t)的右子树由 n-t个数构成 有dp[n-t]种可能
        //那么可得f(t) = dp[t-1]*dp[n-t];
        //由于dp[n]= f(1)+f(2)+...+f(n);
        //可得 dp[n] = dp[0]*dp[n-1]+dp[1]*dp[n-2]+dp[2]*dp[n-3]+dp[3]*dp[n-4]+...+dp[n-1]*dp[0];
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <dp.length ; i++) {
            for (int j = 1; j <=i ; j++) {
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }

}
