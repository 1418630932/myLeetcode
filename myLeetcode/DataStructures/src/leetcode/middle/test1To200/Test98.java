package leetcode.middle.test1To200;

import leetcode.utils.ListNode;
import leetcode.utils.TreeNode;
import leetcode.utils.Utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhuliyang
 * @date 2020-02-27
 * @time 18:24
 **/
public class Test98 {
    public static void main(String[] args) {
        TreeNode tree = Utils.createTree("[10,5,15,null,null,6,20]");
        boolean validBST = isValidBST(tree);
        System.out.println(validBST);
    }
    public static boolean isValidBST(TreeNode root) {
        if (root==null)return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Integer pre =null;
        while (root!=null&&!stack.isEmpty()){
            while (root.left!=null){
                stack.push(root.left);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if (pre!=null&&pre>=pop.val)return false;
            pre=pop.val;
            if (pop.right!=null){
                stack.push(pop.right);
                root = pop.right;
            }
        }
        return true;
    }
    public static boolean isValidBST1(TreeNode root) {
        if (root==null)return false;
        List<Integer> list = new LinkedList<>();
        preOrder(root, list);
        int cur = list.get(0);
        for (int i = 1; i <list.size() ; i++) {
            if (cur>=list.get(i))return false;
            cur = list.get(i);
        }
        return true;
    }

    public  static void preOrder (TreeNode root , List<Integer> list){
        if (root.left!=null){
            preOrder(root.left,list);
        }
        list.add(root.val);
        if (root.right!=null){
            preOrder(root.right,list);
        }
    }
}
