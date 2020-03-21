package leetcode.middle.test201To400;

import leetcode.utils.TreeNode;
import leetcode.utils.Utils;

/**
 * @author zhuliyang
 * @date 2020-03-20
 * @time 13:04
 **/
public class Test236 {
    public static void main(String[] args) {
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
}
