package leetcode.easy.test201To400;

public class Test292 {
    public static void main(String[] args) {
        System.out.println(canWin(3));
    }
    public static   boolean canWinNim(int n) {
        if(n <= 0) {
            return false;
        }
        if(n <= 3) {
            return true;
        }
        //如果我方后手三种情况都是必胜 那么我方这一手必败
        //如果后手三种情况有一种必败 我我方这一手必胜  因为足够聪明 可以抓住这一手
        return !(canWinNim(n-1) && canWinNim(n-2) && canWinNim(n-3));
    }
    public static boolean canWin(int n){
        if (n<=3)return true;
        boolean[] dp = new boolean[n+1];
        for (int i = 0; i <=3 ; i++) {
            dp[i] = true;
        }
        for (int i = 4; i <=n ; i++) {
            dp[i]=!(dp[i-1]&&dp[i-2]&&dp[i-3]);
        }
        return dp[n];
    }
}
