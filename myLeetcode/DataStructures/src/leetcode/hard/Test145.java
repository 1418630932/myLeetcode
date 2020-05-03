package leetcode.hard;

import leetcode.utils.TreeNode;
import leetcode.utils.Utils;
import sun.reflect.generics.tree.Tree;

import javax.xml.soap.Node;
import java.util.*;

/**
 * @author zhuliyang
 * @date 2020-05-03
 * @time 1:09
 **/
public class Test145 {
    public static void main(String[] args) {
        List<Integer> list = postorderTraversal(Utils.createTree("[1,2,3,4,5,6,7]"));
        System.out.println(list);
    }
    public static List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack();
        Set<TreeNode> set = new HashSet<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            if (peek.left!=null&&!set.contains(peek.left)){
                stack.push(peek.left);
                continue;
            }
            if (peek.right!=null&&!set.contains(peek.right)){
                stack.push(peek.right);
                continue;
            }
            TreeNode pop = stack.pop();
            res.add(pop.val);
            set.add(pop);
        }
        return res;
    }
}
