package leetcode.easy.test1To200;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-02-07
 * @time 16:07
 **/
public class Test189 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6};
        rotate(ints,2 );
        System.out.println(Arrays.toString(ints));
    }
    public static void rotate(int[] nums, int k) {
        reverse(nums,0 , nums.length-1);
        reverse(nums,0 , k-1);
        reverse(nums,k , nums.length-1);
    }
    public static void reverse(int[] arr ,int start ,int end){
        while (start<end){
            int temp = arr[end];
            arr[end--]=arr[start];
            arr[start++]=temp;
        }
    }
}
