package leetcode.middle.test201To400;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-03-21
 * @time 14:42
 **/
public class Test240 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        boolean b = searchMatrix(matrix, 9);
        System.out.println(b);

    }
        public static boolean searchMatrix ( int[][] matrix, int target){
            int left = 0;
            int right = matrix[0].length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (matrix[0][mid] < target) {
                    left = mid + 1;
                } else if (matrix[0][mid] > target) {
                    right = mid - 1;
                } else {
                    return true;
                }
            }
            int colunmEnd = right;
            left = 0;
            right = matrix.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (matrix[mid][0] < target) {
                    left = mid + 1;
                } else if (matrix[mid][0] > target) {
                    right = mid - 1;
                } else {
                    return true;
                }
            }
            int rowEnd = right;
            for (int i = 0; i <= rowEnd; i++) {
                for (int j = 0; j <= colunmEnd; j++) {
                    if (matrix[i][j] == target) return true;
                }
            }
            return false;
        }
    }
