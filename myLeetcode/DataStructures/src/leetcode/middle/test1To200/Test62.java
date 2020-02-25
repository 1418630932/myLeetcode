package leetcode.middle.test1To200;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-02-23
 * @time 20:30
 **/
public class Test62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths1(7,3 ));
    }

    public static int uniquePaths1(int m, int n){
        int[][] dp = new int[m][n];
        for (int[] y : dp) {//纵轴
            y[0]=1;
        }
        Arrays.fill(dp[0],1 );//横轴
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <dp[i].length ; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }



    public static int uniquePaths(int m, int n) {
        int[][] table = new int[m][n];
        table[m-1][n-1]=1;//终点
        int paths = move(table,0,0);
        return paths;
    }

    private static int move(int[][] table, int i, int j) {
        if (table[i][j]==1){
            return 1;
        }
        int count =0;
        if (i+1<table.length){
            count+= move(table, i + 1, j);//向下
        }
        if (j+1<table[j].length){
            count+= move(table, i , j + 1);//向右
        }
        return count;
    }


}
