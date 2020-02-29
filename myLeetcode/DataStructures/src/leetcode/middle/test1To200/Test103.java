package leetcode.middle.test1To200;

import leetcode.utils.TreeNode;
import leetcode.utils.Utils;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhuliyang
 * @date 2020-02-28
 * @time 13:50
 **/
public class Test103 {
    public static void main(String[] args) {
        TreeNode tree = Utils.createTree("[3,9,20,null,null,15,7]");
        List<List<Integer>> lists = zigzagLevelOrder(tree);
        System.out.println(lists);
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()||!stack2.isEmpty()){
            List<Integer> list = new LinkedList<>();
            while (!stack1.isEmpty()){
                TreeNode pop = stack1.pop();
                list.add(pop.val);
                if (pop.left!=null)stack2.push(pop.left);
                if (pop.right!=null)stack2.push(pop.right);
            }
            if (list.isEmpty())break;
            res.add(new LinkedList<>(list));
            list.clear();
            while (!stack2.isEmpty()){
                TreeNode pop = stack2.pop();
                list.add(pop.val);
                if (pop.right!=null)stack1.push(pop.right);
                if (pop.left!=null)stack1.push(pop.left);
            }
            if (list.isEmpty())break;
            res.add(new LinkedList<>(list));
        }
        return res;
    }
}
