package leetcode.mianShiTi;

/**
 * @author zhuliyang
 * @date 2020-04-07
 * @time 11:40
 **/
public class Test01_07 {
    public void rotate(int[][] matrix) {
        //对角线交换
        for(int i =0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //中轴线交换
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<=matrix[0].length/2;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[i][matrix[0].length-1-j];
                matrix[i][matrix[0].length-1-j]=temp;
            }
        }
    }
}
