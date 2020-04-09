package leetcode.mianShiTi;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;

/**
 * @author zhuliyang
 * @date 2020-04-09
 * @time 12:13
 **/
public class Test35 {
    public static void main(String[] args) {
        String value = "api-union/member/batch";
        System.out.println(value.replaceAll("=", ""));
    }
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if (head==null)return null;
        Node root = new Node(-1);
        Node cur = head;
        Node cur2 = root;
        HashMap<Node,Integer> map1NToI = new HashMap<>();
        HashMap<Integer,Node> map2IToN = new HashMap<>();
        int count =1;
        while (cur!=null){
            Node newNode =new Node(cur.val);
            cur2.next = newNode;
            cur2 = newNode;
            map1NToI.put(cur,count);
            map2IToN.put(count,newNode);
            count++;
            cur = cur.next;
        }
        cur=head;
        cur2 = root.next;
        while (cur!=null){
           Integer number = map1NToI.get(cur.random);
           Node node = map2IToN.get(number);
           cur2.random= node;
           cur = cur.next;
           cur2=cur2.next;
        }
        return root.next;
    }

}
