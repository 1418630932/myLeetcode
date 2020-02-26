package leetcode.middle.test1To200;

import leetcode.utils.ListNode;
import leetcode.utils.Utils;

/**
 * @author zhuliyang
 * @date 2020-02-26
 * @time 17:17
 **/
public class Test86 {
    public static void main(String[] args) {
        ListNode list = Utils.createList("[1,4,3,2,5,2]");
        ListNode partition = partition(list, 3);
        System.out.println(partition);
    }
    public static ListNode partition(ListNode head, int x) {
        ListNode root1 = new ListNode(-1);
        ListNode temp1 = root1;
        ListNode root2 = new ListNode(-2);
        ListNode temp2 = root2;
        ListNode cur = head;
        while (cur!=null){
            if (cur.val<x){
                temp1.next= new ListNode(cur.val);
                temp1=temp1.next;
            }else {
                temp2.next = new ListNode(cur.val);
                temp2=temp2.next;
            }
            cur=cur.next;
        }
        temp1.next = root2.next;
        return root1.next;
    }
}
