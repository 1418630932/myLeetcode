package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-04
 * @time 15:29
 **/
public class Test110 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(2);
        treeNode1.right=treeNode2;
        treeNode2.left=treeNode3;
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public static boolean isBalanced(TreeNode root) {
        return height(root)!=-1;
    }
    public  static int height(TreeNode root){
        if (root==null){
            return 0;
        }
        int left = height(root.left);
        if (left==-1){return -1;}//-1代表非法 不满足
        int right = height(root.right);
        if (right==-1){return -1;}
        return Math.abs(left-right)>1?-1:Math.max(left,right )+1;
    }
}
