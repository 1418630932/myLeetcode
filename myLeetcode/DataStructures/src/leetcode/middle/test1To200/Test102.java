package leetcode.middle.test1To200;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-02-03
 * @time 19:25
 **/
public class Test102 {
    public static void main(String[] args) {

    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    static List<List<Integer>> LIST = new LinkedList<>();
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null){return LIST;}
        List<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        return LIST ;
    }
    public static void add(List<TreeNode> nodeList){
        if (nodeList.isEmpty()){
            return;
        }
        List<Integer> valList = new LinkedList<>();
        List<TreeNode> nextNodeList  = new LinkedList<>();
        for (int i = 0; i <nodeList.size() ; i++) {
            TreeNode treeNode =nodeList.get(i);
            valList.add(treeNode.val);
            if (treeNode.left!=null){nextNodeList.add(treeNode.left);}
            if (treeNode.right!=null){nextNodeList.add(treeNode.right);}
        }
        LIST.add(valList);
        add(nextNodeList);
    }
}
