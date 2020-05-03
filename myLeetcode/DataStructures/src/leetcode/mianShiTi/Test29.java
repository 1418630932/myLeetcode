package leetcode.mianShiTi;

/**
 * @author zhuliyang
 * @date 2020-04-25
 * @time 14:23
 **/
public class Test29 {
    int count = 0;
    int[][] turn = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[] spiralOrder(int[][] matrix) {
        int[] res = new int[matrix.length * matrix[0].length];
        boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];
        print(isVisited, matrix, res, 0, 0, 1);
        return res;
    }

    private void print(boolean[][] isVisited, int[][] matrix, int[] res, int i, int j, int forword) {
        isVisited[i][j] = true;
        res[count++] = matrix[i][j];
        int[] forwordArr = matrix[forword];
        int x = i + forwordArr[0];
        int y = j + forwordArr[1];
        if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && !isVisited[x][y]) {
            print(isVisited, matrix, res, x, y, forword);
        }
        for (int k = 0; k < turn.length; k++) {
            int y2 = i + turn[k][0];
            int x2 = j + turn[k][1];
            if (x2 >= 0 && x2 < matrix.length && y2 >= 0 && y2 < matrix[0].length && !isVisited[x2][y2]) {
                print(isVisited, matrix, res, x2, y2, k);
            }
        }
    }
}
