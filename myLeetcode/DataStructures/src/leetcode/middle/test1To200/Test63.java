package leetcode.middle.test1To200;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-02-23
 * @time 21:08
 **/
public class Test63 {
    public static void main(String[] args) {
        int i = uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 1}, {0, 0, 0}});
        System.out.println(i);
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 1; i <obstacleGrid.length ; i++) {//纵轴
            if (obstacleGrid[i][0]==1){
                dp[i][0]=0;
                break;
            }
            dp[i][0]=1;

        }
        //横轴
        for (int i = 1; i <obstacleGrid[0].length ; i++) {
            if (obstacleGrid[0][i]==1){
                dp[0][i]=0;
                break;
            }
            dp[0][i]=1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j <obstacleGrid[i].length ; j++) {
                if (obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }
               dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
