package leetcode.middle.test1To200;

import leetcode.utils.TreeNode;
import leetcode.utils.Utils;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-02-29
 * @time 15:52
 **/
public class Test113 {
    public static void main(String[] args) {
        List<List<Integer>> list = pathSum(Utils.createTree("[5,4,8,11,null,13,4,7,2,null,null,5,1]"), 22);
        System.out.println(list);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        helper(res, list, root, sum);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum) {
        if (root == null) return;
        if (root.left == null && root.right == null && sum - root.val == 0) {
            LinkedList<Integer> copyList = new LinkedList<>(list);
            copyList.add(root.val);
            res.add(copyList);
            return;
        }
        list.add(root.val);
        helper(res, list, root.left, sum - root.val);
        helper(res, list, root.right, sum - root.val);
        list.remove(list.size() - 1);//回溯
    }
}
