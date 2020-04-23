package leetcode.mianShiTi;

import leetcode.utils.ListNode;
import leetcode.utils.TreeNode;
import leetcode.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-04-10
 * @time 12:56
 **/
public class Test36 {
    public static void main(String[] args) {
        TreeNode tree = Utils.createTree("[1]");
        TreeNode treeNode = treeToDoublyList(tree);
        System.out.println(1);
    }
    static List<TreeNode> list = new ArrayList<>();
    public static TreeNode treeToDoublyList(TreeNode root) {
        if(root==null)return null;
        inOrder(root);
        if(list.size()==1)return list.get(0);
        for(int i=0;i<list.size();i++){
            if(i==0){
                list.get(i).left = list.get(list.size()-1);
                list.get(i).right = list.get(i+1);
            }else if(i==list.size()-1){
                list.get(i).left = list.get(i-1);
                list.get(i).right = list.get(0);
            }else{
                list.get(i).left = list.get(i-1);
                list.get(i).right = list.get(i+1);
            }
        }
        return list.get(0);
    }
    public static void inOrder(TreeNode root){
        if(root.left!=null){
            inOrder(root.left);
        }
        list.add(root);
        if(root.right!=null){
            inOrder(root.right);
        }
    }
}
