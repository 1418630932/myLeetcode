package leetcode.mianShiTi;

import leetcode.utils.TreeNode;
import leetcode.utils.Utils;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-04-04
 * @time 0:08
 **/
public class Test26 {
    public static void main(String[] args) {
        TreeNode a = Utils.createTree("[3,4,5,1,2]");
        TreeNode b = Utils.createTree("[4,1]");
        isSubStructure(a, b);
    }

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return preOrder(A, B);
    }
    private static boolean preOrder(TreeNode a, TreeNode b) {
        boolean res = check(a, b);
        if (res) return true;
        if (a.left != null) {
            res = preOrder(a.left, b);
        }
        if (!res && a.right != null) {
            res = preOrder(a.right, b);
        }
        return res;
    }

    private static boolean check(TreeNode a, TreeNode b) {
        if (a==null)return false;
        boolean res = a.val==b.val;
        if (b.left!=null){
            res &=check(a.left, b.left);
        }
        if (b.right!=null){
            res &=check(a.right, b.right);
        }
        return res;
    }
}
