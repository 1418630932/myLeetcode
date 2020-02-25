package leetcode.middle.test1To200;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-02-23
 * @time 15:54
 **/
public class Test59 {
    public static void main(String[] args) {
        int[][] ints = generateMatrix(5);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int end = n*n;
        boolean[][] isVisited = new boolean[n][n];
        dfs(isVisited , res,0, 0, 1, 1);
        return res;
    }
    // i ,j 代表起点坐标  turn 代表方向  1右 2下 3左 4上
    public static void dfs(boolean[][] isVisited, int[][] matrix, int i, int j, int turn,int depth) {
        isVisited[i][j] = true;
        matrix[i][j]=depth;
        if (turn==1&&j + 1 < matrix[0].length && !isVisited[i][j+1]){
            dfs(isVisited, matrix, i, j + 1,1,depth+1);//继续向右
        }else if (turn==2&&i + 1 < matrix.length && !isVisited[i+1][j]){
            dfs(isVisited, matrix, i + 1, j,2,depth+1);//继续向下
        }else if (turn==3&&j - 1 >= 0 && !isVisited[i][j-1]){
            dfs(isVisited, matrix, i, j - 1,3,depth+1);//继续向左
        }else if (turn==4&&i - 1 >= 0 && !isVisited[i-1][j]){
            dfs(isVisited, matrix, i - 1, j,4,depth+1);//继续向上
        }

        if (j + 1 < matrix[0].length && !isVisited[i][j+1]) {//1向右
            dfs(isVisited, matrix, i, j + 1,1,depth+1);
        } else if (i + 1 < matrix.length && !isVisited[i+1][j]) {//1向下
            dfs(isVisited, matrix, i + 1, j,2,depth+1);
        } else if (j - 1 >= 0 && !isVisited[i][j-1]) {//1向左
            dfs(isVisited, matrix, i, j - 1,3,depth+1);
        } else if (i - 1 >= 0 && !isVisited[i-1][j]) {//1向上
            dfs(isVisited, matrix, i - 1, j,4,depth+1);
        }
    }
}
