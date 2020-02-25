package leetcode.easy.test201To400;

/**
 * @author zhuliyang
 * @date 2020-02-09
 * @time 15:42
 **/
public class Test226 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root==null)return null;
        TreeNode temp = root.left;
        root.left=invertTree(root.right);
        root.right=invertTree(temp);
        return root;
    }
}
