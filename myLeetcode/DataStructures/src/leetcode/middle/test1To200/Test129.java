package leetcode.middle.test1To200;

import leetcode.utils.ListNode;
import leetcode.utils.TreeNode;
import leetcode.utils.Utils;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-03-01
 * @time 19:36
 **/
public class Test129 {
    public static void main(String[] args) {
        TreeNode tree = Utils.createTree("[4,9,0,5,1]");
        System.out.println(sumNumbers(tree));
    }
    public static int sumNumbers(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        count(root,list ,0 );
        int res = 0;
        for (Integer num : list) {
            res+=num;
        }
        return res;
    }
    public static void count(TreeNode root,List<Integer> list,int target){
        if (root==null)return ;
        if (root.left==null&&root.right==null){
            list.add(target*10+root.val);
            return ;
        }
        count(root.left,list,target*10+root.val);
        count(root.right,list,target*10+root.val);
    }
}
