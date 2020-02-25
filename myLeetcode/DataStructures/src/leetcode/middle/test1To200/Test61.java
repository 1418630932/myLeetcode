package leetcode.middle.test1To200;

import leetcode.utils.ListNode;
import leetcode.utils.Utils;

/**
 * @author zhuliyang
 * @date 2020-02-23
 * @time 18:28
 **/
public class Test61 {
    public static void main(String[] args) {
        ListNode list = Utils.createList("[0,1,2]");
        rotateRight(list,4 );
        System.out.println(1);
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if (head==null)return head;
        int size  = 1;
        ListNode lastNode = head;
        while (lastNode.next!=null){
            lastNode=lastNode.next;
            size++;
        }
        int tailIndex =size- k%size;
        if (tailIndex==size)return head;
        int count =1;
        ListNode tail = head;
        //找到链表移动后的尾巴
        while (count<tailIndex){
            tail=tail.next;
            count++;
        }
        lastNode.next=head;//成环
        ListNode root = tail.next;
        tail.next=null;//断开环
        return root;
    }
}
