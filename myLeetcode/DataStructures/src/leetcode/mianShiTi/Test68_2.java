package leetcode.mianShiTi;

import leetcode.utils.TreeNode;

/**
 * @author zhuliyang
 * @date 2020-04-13
 * @time 18:33
 **/
public class Test68_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null)return null;
        if (root.val==p.val)return p;
        if (root.val==q.val)return q;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left!=null&&right!=null){
            return root;
        }else if (left==null&&right!=null){
            return right;
        }else if (left!=null&&right==null){
            return left;
        }
        return null;
    }
}
