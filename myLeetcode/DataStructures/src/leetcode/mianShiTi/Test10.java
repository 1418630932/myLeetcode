package leetcode.mianShiTi;

/**
 * @author zhuliyang
 * @date 2020-04-02
 * @time 12:35
 **/
public class Test10 {
    public static void main(String[] args) {
        System.out.println(fib(45));
    }
    public static int fib(int n) {
        if(n==0 ||n==1)return n;
        int[] dp = new int[n+1];
        dp[0]= 0;
        dp[1] =1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
