package leetcode.middle.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-22
 * @time 14:42
 **/
public class Test48 {
    public void rotate(int[][] matrix) {
        //转置
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = i; j <matrix[i].length ; j++) {
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //左右镜像
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[j].length/2 ; j++) {
                int temp = matrix[i][j];
                matrix[i][j]=matrix[i][matrix.length-j-1];
                matrix[i][matrix.length-j-1]=temp;
            }
        }
    }
}
