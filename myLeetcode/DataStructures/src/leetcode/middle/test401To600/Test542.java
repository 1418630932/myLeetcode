package leetcode.middle.test401To600;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhuliyang
 * @date 2020-04-15
 * @time 11:26
 **/
public class Test542 {
    public static void main(String[] args) {
        int[][] ints = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        updateMatrix(ints);
    }
    public static int[][] updateMatrix(int[][] matrix) {
        boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];
        Queue<int[]> queue = new LinkedList();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    isVisited[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                if (x - 1 >= 0 && !isVisited[x - 1][y]) {
                    queue.add(new int[]{x - 1, y});
                    isVisited[x - 1][y] = true;
                    matrix[x - 1][y] = depth + 1;
                }
                if (x + 1 < matrix.length && !isVisited[x + 1][y]) {
                    queue.add(new int[]{x + 1, y});
                    isVisited[x + 1][y] = true;
                    matrix[x + 1][y] = depth + 1;
                }
                if (y - 1 >= 0 && !isVisited[x][y - 1]) {
                    queue.add(new int[]{x, y - 1});
                    isVisited[x][y - 1] = true;
                    matrix[x][y - 1] = depth + 1;
                }
                if (y + 1 < matrix[0].length && !isVisited[x][y + 1]) {
                    queue.add(new int[]{x, y + 1});
                    isVisited[x][y + 1] = true;
                    matrix[x][y + 1] = depth + 1;
                }
            }
            depth++;
        }
        return matrix;
    }
}
