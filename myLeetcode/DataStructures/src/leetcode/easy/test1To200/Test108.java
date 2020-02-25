package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-04
 * @time 14:47
 **/
public class Test108 {
    public static void main(String[] args) {
        TreeNode treeNode = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println();
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode helper = helper(nums, 0, nums.length-1);
        return helper;
    }
    public static TreeNode helper(int[] nums,int start,int end) {
        if (start>end)return null;
        int mid = (start+end)>>>1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left=helper(nums,start ,mid-1 );
        root.right=helper(nums,mid+1 ,end );
        return root;
    }
}
