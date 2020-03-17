package leetcode.middle.test201To400;

import leetcode.utils.TreeNode;

/**
 * @author zhuliyang
 * @date 2020-03-17
 * @time 20:02
 **/
public class Test222 {
    public int countNodes(TreeNode root) {
        if(root==null)return 0;
        int left = deepLeft(root.left);
        int right = deepLeft(root.right);
        if (left==right){//左右高度相等 说明左边是满的
            return countNodes(root.right)+ (int) Math.pow(2, left);
        }else {//左右高度不等 说明右边是满的
            return countNodes(root.left)+(int) Math.pow(2, right);
        }
    }

    private int deepLeft(TreeNode root) {
        if (root==null)return 0;
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }
}
