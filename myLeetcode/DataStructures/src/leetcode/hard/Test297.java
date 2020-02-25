package leetcode.hard;

import leetcode.utils.TreeNode;
import leetcode.utils.Utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author zhuliyang
 * @date 2020-02-20
 * @time 16:24
 **/
public class Test297 {
    public static void main(String[] args) {
        TreeNode tree = Utils.createTree("[1,2,3,4,5,6,7,null,null,null,7]");
        String serialize = serialize(tree);
        System.out.println(serialize);
        deserialize(serialize);
        System.out.println(serialize);
    }
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root==null)return "[]";
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            sb.append(poll==null?"null":poll.val).append(",");
            if (poll!=null) {
                queue.add(poll.left);
                queue.add(poll.right);
            }
        }
        return sb.replace(sb.length()-1,sb.length() , "]").toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data==null) return null;
        String substring = data.substring(1, data.length() - 1);//掐头去尾
        if (substring.length()==0)return null;
        String[] split = substring.split(",");//按照逗号分割
        TreeNode root = split[0].equals("null")?null:new TreeNode(Integer.parseInt(split[0]));//树的root节点
        Queue<TreeNode> queue = new LinkedBlockingQueue<>(); //广度优先的辅助队列
        queue.add(root);
        int index = 1;//数组的索引下标
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (index<split.length){//如果下标越界就跳出while循环
                cur.left = split[index].equals("null")?null:new TreeNode(Integer.parseInt(split[index]));
                index++;
                if (cur.left!=null){//如果节点是null 就不放人队列
                    queue.add(cur.left);
                }
            }else {break;}
            if (index<split.length){//如果下标越界就跳出while循环
                cur.right= split[index].equals("null")?null:new TreeNode(Integer.parseInt(split[index]));
                index++;
                if (cur.right!=null){//如果节点是null 就不放人队列
                    queue.add(cur.right);
                }
            }else {break;}
        }
        return root;
    }
}
