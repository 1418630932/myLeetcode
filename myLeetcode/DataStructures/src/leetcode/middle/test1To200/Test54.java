package leetcode.middle.test1To200;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-02-22
 * @time 18:24
 **/
public class Test54 {
    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3,4}, {5,6,7,8}, {9,10,11,12},{13,14,15,16}}));
    }

        public static List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new LinkedList<>();
            boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];
            dfs(isVisited, res, matrix, 0, 0,1);
            return res;
        }

        // i ,j 代表起点坐标  turn 代表方向  1右 2下 3左 4上
        public static void dfs(boolean[][] isVisited, List<Integer> res, int[][] matrix, int i, int j,int turn) {
            res.add(matrix[i][j]);
            isVisited[i][j] = true;
            if (turn==1&&j + 1 < matrix[0].length && !isVisited[i][j+1]){
                dfs(isVisited, res, matrix, i, j + 1,1);//继续向右
            }else if (turn==2&&i + 1 < matrix.length && !isVisited[i+1][j]){
                dfs(isVisited, res, matrix, i + 1, j,2);//继续向下
            }else if (turn==3&&j - 1 >= 0 && !isVisited[i][j-1]){
                dfs(isVisited, res, matrix, i, j - 1,3);//继续向左
            }else if (turn==4&&i - 1 >= 0 && !isVisited[i-1][j]){
                dfs(isVisited, res, matrix, i - 1, j,4);//继续向上
            }

            if (j + 1 < matrix[0].length && !isVisited[i][j+1]) {//1向右
                dfs(isVisited, res, matrix, i, j + 1,1);
            } else if (i + 1 < matrix.length && !isVisited[i+1][j]) {//1向下
                dfs(isVisited, res, matrix, i + 1, j,2);
            } else if (j - 1 >= 0 && !isVisited[i][j-1]) {//1向左
                dfs(isVisited, res, matrix, i, j - 1,3);
            } else if (i - 1 >= 0 && !isVisited[i-1][j]) {//1向上
                dfs(isVisited, res, matrix, i - 1, j,4);
            }
        }
}
