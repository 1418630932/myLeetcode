package leetcode.middle.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-24
 * @time 14:08
 **/
public class Test64 {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        //第一行初始化
        for (int i = 1; i <dp[0].length ; i++) {
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }
        //第一列初始化
        for (int i = 1; i <dp.length ; i++) {
            dp[i][0]= dp[i-1][0]+grid[i][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
