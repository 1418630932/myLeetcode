package leetcode.middle.test1To200;

import leetcode.utils.TreeNode;
import leetcode.utils.Utils;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhuliyang
 * @date 2020-03-12
 * @time 21:03
 **/
public class Test199 {
    public static void main(String[] args) {
        List<Integer> list = rightSideView(Utils.createTree("[1,2,3,null,5,null,4]"));
        System.out.println(list);
    }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root==null)return res;
        queue.add(root);
        while (!queue.isEmpty()){
            res.add (queue.getLast().val);
            int size = queue.size();
            for (int i = 0; i <size ; i++) {
                TreeNode poll = queue.poll();
                if (poll.left!=null)queue.add(poll.left);
                if (poll.right!=null)queue.add(poll.right);
            }
        }
        return res;
    }
}
