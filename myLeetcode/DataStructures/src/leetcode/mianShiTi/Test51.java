package leetcode.mianShiTi;

import leetcode.utils.TreeNode;

import java.util.*;

/**
 * @author zhuliyang
 * @date 2020-04-24
 * @time 0:40
 **/
public class Test51 {
    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{7,5,6,4}));
    }

    public static int reversePairs(int[] nums) {
        int count = merge(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        return count;
    }

    static int merge(int[] arr, int start, int end) {
        if (start == end) return 0;
        int mid = (start + end) / 2;
        int count = merge(arr, start, mid) + merge(arr, mid + 1, end);

        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            count += arr[i] > arr[j] ? mid-i+1 :0 ;
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end)
            temp[k++] = arr[j++];
        System.arraycopy(temp, 0, arr, start, end - start + 1);
        return count;
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left==null&&right==null)return true;
        if (left==null||right==null)return false;
        return check(left.left,right.right )&&check(left.right,right.left );
    }

}
