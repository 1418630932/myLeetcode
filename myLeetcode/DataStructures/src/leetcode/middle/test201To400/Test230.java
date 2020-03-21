package leetcode.middle.test201To400;

import leetcode.utils.TreeNode;
import leetcode.utils.Utils;

/**
 * @author zhuliyang
 * @date 2020-03-20
 * @time 12:43
 **/
public class Test230 {
    public static void main(String[] args) {
        int i = kthSmallest(Utils.createTree("[1,null,2]"), 2);
        System.out.println(i);
    }
    static int  count =0;
    public static int kthSmallest(TreeNode root, int k) {
        int val =0;
        if (root.left!=null&&count!=k){
             val = kthSmallest(root.left, k);
        }
        if (count==k)return val;
        count++;
        if (count==k)return root.val;
        if (root.right!=null){
             val = kthSmallest(root.right, k);
        }
        return val;
    }
}
