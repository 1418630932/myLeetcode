package leetcode.middle.test201To400;

/**
 * @author zhuliyang
 * @date 2020-03-17
 * @time 18:04
 **/
public class Test221 {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
        }
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int top = dp[i - 1][j];
                    int left = dp[i][j - 1];
                    int conner = dp[i - 1][j - 1];
                    dp[i][j] = Math.min(conner, Math.min(top, left)) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
