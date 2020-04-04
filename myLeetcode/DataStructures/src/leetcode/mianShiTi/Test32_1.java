package leetcode.mianShiTi;

import leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhuliyang
 * @date 2020-04-04
 * @time 14:14
 **/
public class Test32_1 {
    public int[] levelOrder(TreeNode root) {
        if (root==null)return null;
        List<Integer> list =new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left!=null)queue.add(poll.left);
                if (poll.right!=null)queue.add(poll.right);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
