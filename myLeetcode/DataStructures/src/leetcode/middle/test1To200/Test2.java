package leetcode.middle.test1To200;

import leetcode.utils.ListNode;
import leetcode.utils.Utils;

/**
 * @author zhuliyang
 * @date 2020-02-16
 * @time 15:13
 **/
public class Test2 {
    public static void main(String[] args) {
        ListNode listNode1 = Utils.createList("[9]");
        ListNode listNode2 = Utils.createList("[1,9,9,9,9,9,9,9,9,9]");
        addTwoNumbers(listNode1,listNode2 );
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode root = new ListNode(-1);
        ListNode temp = root;
        while (temp1!=null||temp2!=null||add!=0){
            int sum =0;
            sum+=add;
            if (temp1!=null){
                sum+=temp1.val;
                temp1=temp1.next;
            }
            if (temp2!=null){
                sum+=temp2.val;
                temp2=temp2.next;
            }
            ListNode tail = new ListNode(sum%10);
            add = sum/10;
            temp.next=tail;
            temp=tail;
        }
        return root.next;
    }

}
