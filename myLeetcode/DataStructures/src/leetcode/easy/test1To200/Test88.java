package leetcode.easy.test1To200;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-02-02
 * @time 16:26
 **/
public class Test88 {
    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,2,2}, 3);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = Arrays.copyOf(nums1,m );
        int index =0;
        int i=0;
        int j=0;
        while ((i<m&&j<n)){
            if (temp[i]<nums2[j]){
               nums1[index++]=temp[i++];
            } else {
                nums1[index++]=nums2[j++];
            }
            if (j==n){
                for (int k = i; k <m ; k++) {
                    nums1[index++]=temp[k];
                }
            }
            if (i==m){
                for (int k = j; k <n ; k++) {
                    nums1[index++]=nums2[k];
                }
            }
        }
        if (m==0){
            for (int k = j; k <n ; k++) {
                nums1[index++]=nums2[k];
            }
        }
        System.out.println(1);
    }
}
