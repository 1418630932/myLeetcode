package leetcode.mianShiTi;

/**
 * @author zhuliyang
 * @date 2020-03-31
 * @time 19:29
 **/
public class Test4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length-1;
        int j = 0;
        while (i>=0){
            int num = matrix[i][j];
            if (target==num){
                return true;
            }else if (target>num){
                for (int k = j; k < matrix[0].length; k++) {
                    if (matrix[i][k]==target)return true;
                    if (k==matrix[0].length-1)i--;
                }
            }else {
                i--;
            }
        }
        return false;
    }
}
