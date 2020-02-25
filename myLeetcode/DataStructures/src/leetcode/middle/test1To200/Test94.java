package leetcode.middle.test1To200;

import leetcode.utils.TreeNode;
import leetcode.utils.Utils;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhuliyang
 * @date 2020-02-25
 * @time 14:14
 **/
public class Test94 {
    public static void main(String[] args) {
        TreeNode tree = Utils.createTree("[2,3,null,1]");
        List<Integer> list = inorderTraversal(tree);
        System.out.println(list);
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root==null)return null;
        Stack<TreeNode> stack = new Stack();
        List<Integer> res = new LinkedList<>();
        TreeNode cur = root;
        while (cur!=null||!stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode peek = stack.peek();
            res.add(stack.pop().val);
            cur = peek.right;
        }
        return res;
    }
}
