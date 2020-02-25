package leetcode.easy.test201To400;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-02-10
 * @time 14:24
 **/
public class Test257 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    List<String> res = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        String str = root.val+"";
        help(root,str );
        return res;
    }
    public void help(TreeNode root,String str){
        if (root.left==null&&root.right==null){
            res.add(str);
        }
        if (root.left!=null){
            help(root.left, str+"->"+root.left.val);
        }
        if (root.right!=null){
            help(root.right, str+"->"+root.right.val);
        }
    }
}
