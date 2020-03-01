package leetcode.middle.test1To200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhuliyang
 * @date 2020-03-01
 * @time 15:40
 **/
public class Test116 {
    public static void main(String[] args) {
        Node root1 = new Node(1);
        Node root2 = new Node(2);
        Node root3 = new Node(3);
        root1.left=root2; root1.right=root3;
        Node root4 = new Node(4);
        Node root5 = new Node(5);
        root2.left = root4; root2.right = root5;
        Node root6 = new Node(6);
        Node root7 = new Node(7);
        root3.left = root6; root3.right =root7;
        Node connect = connect1(root1);
        System.out.println(connect);
    }
    public static Node connect1(Node root){
        if (root==null)return null;
        if (root.left!=null){
            root.left.next = root.right;
        }
        if (root.right!=null){
            root.right.next = root.next==null?null:root.next.left;
        }
        connect1(root.left);
        connect1(root.right);
        return root;
    }


    public static Node connect(Node root) {
        if (root==null)return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i <size ; i++) {
                Node poll = queue.poll();
                poll.next = i==size-1?null:queue.peek();
                if (poll.left!=null){
                    queue.add(poll.left);
                }
                if (poll.right!=null){
                    queue.add(poll.right);
                }
            }
        }
        return root;
    }
    static  class  Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}


