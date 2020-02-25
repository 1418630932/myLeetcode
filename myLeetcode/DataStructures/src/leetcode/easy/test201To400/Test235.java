package leetcode.easy.test201To400;

/**
 * @author zhuliyang
 * @date 2020-02-09
 * @time 22:41
 **/
public class Test235 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val<root.val&&q.val<root.val){//都在左子树
            return lowestCommonAncestor(root.left,p ,q );
        }
        if (p.val>root.val&&q.val>root.val){//都在右子树
            return lowestCommonAncestor(root.right,p ,q );
        }
        return root;//一个在做 一个在右
    }
}
