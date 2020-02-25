package leetcode.easy.test401To600;

/**
 * @author zhuliyang
 * @date 2020-02-14
 * @time 15:46
 **/
public class Test437 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(-2);
        TreeNode t2 = new TreeNode(-3);
        root.left = t1;
        root.right = t2;
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(-2);
        TreeNode t6 = null;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        TreeNode t7 = new TreeNode(-1);
        t3.left = t7;
        System.out.println(pathSum(root, -1));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int pathSum(TreeNode root, int sum) {
        if (root== null) return 0;
        return helper(root, sum)+pathSum(root.left, sum)+pathSum(root.right, sum);
    }

    public static int helper(TreeNode root, int sum) {
        int res = 0;
        if (sum - root.val == 0) {
            res++;
        }
        if (root.left != null) {
            res += helper(root.left, sum - root.val);
        }
        if (root.right != null) {
            res += helper(root.right, sum - root.val);
        }
        return res;
    }
}
