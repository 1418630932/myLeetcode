package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-04
 * @time 17:37
 **/
public class Test111 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    int min=Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        helper(root,1 );
        return root==null?0:min;
    }
    public void helper(TreeNode root,int  depth){
        if (root.left==null&&root.right==null){
            min=Math.min(min,depth );
        }
        if (root.left!=null){
            helper(root.left,depth+1 );
        }
        if (root.right!=null){
            helper(root.right,depth+1 );
        }
    }
}
