package leetcode.middle.test1To200;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-03-04
 * @time 12:48
 **/
public class Test138 {
    static class Node {
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
        HashMap<Node,Node> map = new HashMap<>();
        Node temp = head;
        while (temp!=null){
            map.put(temp, new Node(temp.val));
            temp =temp.next;
        }
        Node p = head;
        while (p!=null){
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p=p.next;
        }
        return map.get(head);
    }
}
