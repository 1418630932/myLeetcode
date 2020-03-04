package leetcode.easy.test801To1000;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhuliyang
 * @date 2020-03-04
 * @time 11:13
 **/
public class Test994 {
    public static void main(String[] args) {
        int i = orangesRotting(new int[][]{{0}});
        System.out.println(i);
    }

    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        //记录是否腐烂
        boolean[][] isVisiTed = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        int mintues = 0;
        int freshOrangeCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});//记录腐烂橘子的行列
                    isVisiTed[i][j] = true;
                } else if (grid[i][j] == 0) {
                    isVisiTed[i][j] = true;
                }else {
                    freshOrangeCount++;//新鲜水果数量
                }
            }
        }
        //bfs
        while (!queue.isEmpty()&&freshOrangeCount>0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int row = poll[0];//行
                int column = poll[1];//列
                if (row > 0 && !isVisiTed[row - 1][column]) {
                    queue.add(new int[]{row - 1, column});
                    isVisiTed[row - 1][column] = true;
                    freshOrangeCount--;
                }
                if (row < rows - 1 && !isVisiTed[row + 1][column]) {
                    queue.add(new int[]{row + 1, column});
                    isVisiTed[row + 1][column] = true;
                    freshOrangeCount--;
                }
                if (column > 0 && !isVisiTed[row][column - 1]) {
                    queue.add(new int[]{row, column - 1});
                    isVisiTed[row][column - 1] = true;
                    freshOrangeCount--;
                }
                if (column < columns - 1 && !isVisiTed[row][column + 1]) {
                    queue.add(new int[]{row, column + 1});
                    isVisiTed[row][column + 1] = true;
                    freshOrangeCount--;
                }
            }
            mintues++;//腐烂迭代数+1
        }
        return freshOrangeCount>0? -1:mintues;
    }
}
