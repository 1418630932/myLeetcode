package leetcode.mianShiTi;

import leetcode.utils.TreeNode;

/**
 * @author zhuliyang
 * @date 2020-04-03
 * @time 13:18
 **/
public class Test27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root==null)return null;
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
}
