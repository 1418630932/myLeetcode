package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-04
 * @time 18:35
 **/
public class Test112 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){return false;}
        if (root.left==null&&root.right==null){//根节点
            return sum==root.val;
        }
        return hasPathSum(root.left, sum - root.val)||hasPathSum(root.right, sum - root.val);
    }
}
