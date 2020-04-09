package leetcode.mianShiTi;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhuliyang
 * @date 2020-04-08
 * @time 11:58
 **/
public class Test13 {
    public static void main(String[] args) {
        int i = movingCount(38, 15, 9);
        System.out.println(i);
    }

    public static int movingCount(int m, int n, int k) {
        boolean[][] isVisited = new boolean[m][n];
        int count = 0;
        isVisited[0][0] = true;
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            count += size;
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int x = poll[0]; int y = poll[1];
                if (x + 1 < m && !isVisited[x + 1][y] &&  getNumber(x+1,y ) <= k) {
                    queue.add(new int[]{x+1, y});
                    isVisited[x+1][y] = true;
                }
                if (y + 1 < n && !isVisited[x][y + 1] && getNumber(x, y+1)<= k) {
                    queue.add(new int[]{x, y + 1});
                    isVisited[x][y + 1] = true;
                }
            }
        }
        return count;
    }

    private static int getNumber(int x, int y) {
        int res =0;
        while (x > 0) {
            res += x % 10;
            x /= 10;
        }
        while (y > 0) {
            res += y% 10;
            y /= 10;
        }
        return res;
    }
}
