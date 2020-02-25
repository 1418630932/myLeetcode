package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-01-31
 * @time 19:19
 **/
public class Test35 {
    public static void main(String[] args) {
        int i = searchInsert(new int[]{1, 3, 5, 6}, 9);
        System.out.println(i);
    }
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = -1 ;
        while (left<=right){
            mid =(left+right)>>>1;
            if (nums[mid]<target){
                left=mid+1;
            }else if (nums[mid]>target){
                right=mid-1;
            }else {
                return mid;
            }
        }
        return left;
    }
}
