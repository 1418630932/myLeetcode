package leetcode.hard;

import leetcode.utils.ListNode;
import leetcode.utils.Utils;

import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-05-16
 * @time 0:07
 **/
public class Test25 {
    public static void main(String[] args) {
        ListNode list = Utils.createList("[1,2,3,4,5]");
        ListNode node = reverseKGroup(list, 4);
        System.out.println(1);
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head==null)return head;
        ListNode secPoint = head;
        for (int i = 0; i <k ; i++) {
            secPoint = secPoint.next;
            if (secPoint==null)return head;
        }
        ListNode root = new ListNode(-1);
        ListNode dummy = root;
        root.next = head;
        while (true){
            ListNode cur = head.next;
            while (cur!=secPoint){
                ListNode temp = cur.next;
                ListNode rootNext = dummy.next;
                dummy.next = cur;
                cur.next = rootNext;
                head.next = temp;
                if (temp ==secPoint)dummy = head;
                cur = temp;
            }
            head =secPoint;
            for (int i = 0; i <k ; i++) {
                secPoint = secPoint.next;
                if (secPoint==null)return root.next;
            }
        }
    }
}
