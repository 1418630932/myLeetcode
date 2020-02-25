package leetcode.middle.test1To200;

import leetcode.utils.ListNode;
import leetcode.utils.Utils;

/**
 * @author zhuliyang
 * @date 2020-02-19
 * @time 18:19
 **/
public class Test19 {
    public static void main(String[] args) {
        ListNode list = Utils.createList("[1]");
        removeNthFromEnd(list,1 );
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 =head;
        while(n>0){
            p1=p1.next;
            n--;
        }
        ListNode root = new ListNode(0);
        root.next=head;
        ListNode p2 = root;
        while(p1!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return root.next;
    }
}
