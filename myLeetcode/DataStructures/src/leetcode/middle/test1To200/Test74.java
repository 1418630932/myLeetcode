package leetcode.middle.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-24
 * @time 15:51
 **/
public class Test74 {
    public static void main(String[] args) {
        boolean b = searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 34);
        System.out.println(b);
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0)return false;
        //二分查找起始行
        int left = 0;
        int right = (matrix.length)*(matrix[0].length)-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            int element = matrix[mid/matrix[0].length][mid%matrix[0].length];
            if (element<target){
                left= mid+1;
            }else if (element>target){
                right=mid-1;
            }else {
                return true;
            }
        }
        return false;
    }
}
