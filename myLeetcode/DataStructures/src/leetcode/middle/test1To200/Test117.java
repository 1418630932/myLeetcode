package leetcode.middle.test1To200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhuliyang
 * @date 2020-03-01
 * @time 16:26
 **/
public class Test117 {
    public static void main(String[] args) {
        Node root1 = new Node(2);
        Node root2 = new Node(1);
        Node root3 = new Node(3);
        root1.left=root2; root1.right=root3;
        Node root4 = new Node(0);
        Node root5 = new Node(7);
        root2.left = root4;root2.right = root5;
        Node root6 = new Node(9);
        Node root7 = new Node(1);
        root3.left = root6;root3.right =root7;
        Node root8 = new Node(2);
        root4.left = root8;
        Node root9 = new Node(1);
        Node root10 = new Node(0);
        root5.left= root9; root5.right =root10;
        Node root11 = new Node(8);
        Node root12 = new Node(8);
        root7.left  = root11; root7.right = root12;
        Node connect = connect1(root1);
        System.out.println(connect);
    }
    public static Node connect(Node root){
        if (root==null)return null;
        if (root.right!=null){
            if (root.next==null){
                root.right.next = null;
            }else {
                Node next = root.next;
                while (next!=null&&next.left==null&&next.right==null){
                    next = next.next;
                }
                root.right.next = next==null?null:next.left!=null?next.left:next.right;
            }
        }
        if (root.left!=null){
            if (root.right!=null){
                root.left.next = root.right;
            }else {
                Node next = root.next;
                while (next!=null&&next.left==null&&next.right==null){
                    next = next.next;
                }
                root.left.next = next==null?null:next.left!=null? next.left: next.right;
            }
        }
        connect(root.right);
        connect(root.left);
        return root;
    }

//
    public static Node connect1(Node root) {
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
