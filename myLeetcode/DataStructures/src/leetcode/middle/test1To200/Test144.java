package leetcode.middle.test1To200;

import leetcode.utils.ListNode;
import leetcode.utils.TreeNode;
import leetcode.utils.Utils;

import javax.rmi.CORBA.Util;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zhuliyang
 * @date 2020-03-06
 * @time 17:21
 **/
public class Test144 {
    public static void main(String[] args) {
        List<Integer> list = preorderTraversal(Utils.createTree("[1,2,3,4,5,6,7,null,8]"));
        System.out.println(list);
    }
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root==null)return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        res.add(root.val);
        while (!stack.isEmpty()){
            while (root.left!=null){
                res.add(root.left.val);
                stack.push(root.left);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if (pop.right!=null){
                root = pop.right;
                stack.push(pop.right);
                res.add(pop.right.val);
            }
        }
        return res;
    }
}
