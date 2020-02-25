package leetcode.middle.test1To200;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-02-20
 * @time 16:19
 **/
public class Test34 {
    public static void main(String[] args) {
        int[] ints = searchRange(new int[]{5, 7, 7, 8,8,9,10,11}, 9);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] searchRange(int[] nums, int target) {
        if(nums==null)return new int[] {-1,-1};
        int left = 0;
        int right = nums.length-1;
        int targetIndex =-1;
        //二分查找
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid-1;
            }else{
                targetIndex=mid;
                break;
            }
        }
        if (targetIndex==-1)return new int[] {-1,-1};
        int start = findLeft( nums,target, targetIndex); //二分查找左边界
        int end = findRight( nums,target, targetIndex);//二分查找右边界
        return new int[]{start,end};
    }
    //0~targtIndex
    private static int findLeft(int[] nums, int target, int targetIndex) {
        int left = 0;
        int right = targetIndex;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]==target){
                right = mid-1;
            }
        }
        return left;
    }
    //tagetIndex~nums.length
    private static int findRight(int[] nums, int target, int targetIndex) {
        int left = targetIndex;
        int right = nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid]==target){
                left = mid+1;
            }
        }
        return right;
    }
}
