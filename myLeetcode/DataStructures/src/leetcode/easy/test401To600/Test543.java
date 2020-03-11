package leetcode.easy.test401To600;

import leetcode.utils.TreeNode;

/**
 * @author zhuliyang
 * @date 2020-03-10
 * @time 17:34
 **/
public class Test543 {
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        deepth(root);
        return max;
    }
    public int deepth(TreeNode root){
        if(root==null)return 0;
        int left = deepth(root.left);
        int right = deepth(root.right);
        max = Math.max(max,left+right );
        return Math.max(left, right)+1;
    }
}
