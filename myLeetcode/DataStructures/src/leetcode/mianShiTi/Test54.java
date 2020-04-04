package leetcode.mianShiTi;

import leetcode.utils.TreeNode;
import leetcode.utils.Utils;

import java.util.LinkedList;

/**
 * @author zhuliyang
 * @date 2020-04-03
 * @time 23:52
 **/
public class Test54 {
    public static void main(String[] args) {
        TreeNode tree = Utils.createTree("[3,1,4,null,2]");
        int i = kthLargest(tree, 1);
        System.out.println(i);
    }
    private  static LinkedList<Integer> list = new LinkedList();
    public static int kthLargest(TreeNode root, int k) {
        postOrder(root,k);
        return list.get(list.size()-1);
    }
    public static void postOrder(TreeNode root, int k){
        if (list.size()>=k)return;
        if(root.right!=null){
            postOrder(root.right,k);
        }
        if (list.size()>=k)return;
        list.add(root.val);
        if(root.left!=null){
            postOrder(root.left,k);
        }
    }
}
