package leetcode.middle.test201To400;

/**
 * @author zhuliyang
 * @date 2020-03-28
 * @time 16:52
 **/
public class Test304 {
    public static void main(String[] args) {
        NumMatrix matrix = new NumMatrix(new int[][]{  {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}});
        int i = matrix.sumRegion(1, 2, 2, 4);
        System.out.println(i);
    }
}
class NumMatrix {
    int[][] dp ;
    public NumMatrix(int[][] matrix) {
        if (matrix.length==0||matrix[0].length==0)return;
        dp = new int[matrix.length][matrix[0].length];
        dp[0][0]= matrix[0][0];
        for (int i = 1; i <matrix[0].length ; i++) {
            dp[0][i] = dp[0][i-1]+matrix[0][i];
        }
        for (int i = 1; i <matrix.length ; i++) {
            dp[i][0] = dp[i-1][0]+matrix[i][0];
        }
        for (int i = 1; i <matrix.length ; i++) {
            for (int j = 1; j <matrix[0].length ; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+matrix[i][j];
            }
        }
        System.out.println(1);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (dp==null)return 0;
        return dp[row2][col2]+dp[row1-1][col1-1]-dp[row1-1][col2]-dp[row2][col1-1];
    }
}
