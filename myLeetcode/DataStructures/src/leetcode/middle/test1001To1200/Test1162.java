package leetcode.middle.test1001To1200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhuliyang
 * @date 2020-03-29
 * @time 14:17
 **/
public class Test1162 {
    public static void main(String[] args) {
        int i = maxDistance(new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}});
        System.out.println(i);
    }
    public static int maxDistance(int[][] grid) {
        int depth = -1;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    isVisited[i][j] = true;
                }
            }
        }
        if(queue.size()==grid.length*grid.length)return -1;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                if (x - 1 >= 0 && !isVisited[x - 1][y]) {
                    queue.add(new int[]{x - 1, y});
                    isVisited[x - 1][y] = true;
                }
                if (x + 1 < grid.length && !isVisited[x + 1][y]) {
                    queue.add(new int[]{x + 1, y});
                    isVisited[x + 1][y] = true;
                }
                if (y - 1 >= 0 && !isVisited[x][y - 1]) {
                    queue.add(new int[]{x, y - 1});
                    isVisited[x][y - 1] = true;
                }
                if (y + 1 < grid.length && !isVisited[x][y + 1]) {
                    queue.add(new int[]{x, y+1});
                    isVisited[x ][y + 1] = true;
                }
            }
        }
        return depth;
    }
}
