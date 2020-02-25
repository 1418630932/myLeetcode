package leetcode.middle.test1To200;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-02-24
 * @time 15:14
 **/
public class Test73 {
    public static void main(String[] args) {
        int[][] ints = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(ints);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }

    public static void setZeroes(int[][] matrix) {
        boolean[][] isChanged = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!isChanged[i][j]&&matrix[i][j]==0) {
                    for (int k = 0; k < matrix[i].length; k++) {//更新行
                        if (matrix[i][k] != 0) {
                            matrix[i][k] = 0;
                            isChanged[i][k]=true;
                        }
                    }
                    for (int k = 0; k < matrix.length; k++) {//更新列
                        if (matrix[k][j] != 0) {
                            matrix[k][j] = 0;
                            isChanged[k][j]=true;
                        }
                    }
                }
            }
        }
    }
}
