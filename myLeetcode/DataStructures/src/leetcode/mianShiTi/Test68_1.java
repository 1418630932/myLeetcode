package leetcode.mianShiTi;

import leetcode.utils.TreeNode;

/**
 * @author zhuliyang
 * @date 2020-04-13
 * @time 18:28
 **/
public class Test68_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null)return null;
        if (p.val<root.val&&q.val<root.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if (p.val>root.val&&q.val>root.val){
            return lowestCommonAncestor(root.right,p ,q );
        }else {
            return root;
        }
    }
}
