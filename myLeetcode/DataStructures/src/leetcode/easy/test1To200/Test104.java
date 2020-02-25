package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-03
 * @time 16:43
 **/
public class Test104 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left=t2; t1.right=t3;
        System.out.println(Math.log(8)/Math.log(2));
    }
    public static int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right )+1;
    }
}
