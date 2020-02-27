package leetcode.middle.test1To200;

import leetcode.utils.TreeNode;
import leetcode.utils.Utils;

/**
 * @author zhuliyang
 * @date 2020-02-27
 * @time 21:59
 **/
public class Test114 {
    public static void main(String[] args) {
        TreeNode tree = Utils.createTree("[1,2,5,3,4,null,6]");
        flatten(tree);
        System.out.println(tree);
    }
    public static void flatten(TreeNode root) {
        if(root==null)return;
        if(root.left==null&&root.right==null)return;
        flatten(root.left);
        flatten(root.right);
        if(root.left!=null){
            TreeNode temp = root.left;
            while(temp.right!=null){
                temp = temp.right;
            }
            temp.right = root.right;
            root.right = root.left;
            root.left =null;
        }
    }
}
