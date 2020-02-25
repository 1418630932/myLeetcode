package leetcode.easy.test401To600;

/**
 * @author zhuliyang
 * @date 2020-02-13
 * @time 14:08
 **/
public class Test404 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root,0 );
    }
    //flag=1 当前是left节点 flag =2 当前是right节点
    public int helper(TreeNode root,int flag){
        int sum = 0;
        if (root.left==null&&root.right==null&&flag==1)return root.val;
        if (root.left!=null){
            sum+=helper(root.left,1);
        }
        if (root.right!=null){
            sum+=helper(root.right,2);
        }
        return sum;
    }
}
