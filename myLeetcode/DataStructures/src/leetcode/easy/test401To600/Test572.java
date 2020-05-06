package leetcode.easy.test401To600;

import leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhuliyang
 * @date 2020-05-07
 * @time 0:02
 **/
public class Test572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s==null)return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (poll.val==t.val){
                if (equals(poll,t ))return true;
            }
            if (poll.left!=null){
                queue.add(poll.left);
            }
            if (poll.right!=null){
                queue.add(poll.right);
            }
        }
        return false;
    }
    public boolean equals(TreeNode s,TreeNode t){
        if (s==null&&t==null)return true;
        if (s==null || t==null)return false;
        if (s.val!=t.val)return false;
        return equals(s.left,t.left)&&equals(s.right,t.right);
    }
}
