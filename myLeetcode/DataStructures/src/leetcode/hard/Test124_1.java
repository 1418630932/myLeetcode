package leetcode.hard;

import leetcode.utils.TreeNode;

/**
 * @author zhuliyang
 * @date 2020-06-21
 * @time 13:38
 **/
public class Test124_1 {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return  res;
    }

    private int getMax(TreeNode root) {
        if (root==null)return 0;
        int leftVal = getMax(root.left);
        int rightVal = getMax(root.right);
        res = Math.max(res,root.val+leftVal+rightVal );
        return Math.max(0,root.val+Math.max(leftVal,rightVal));
    }
}
