package leetcode.mianShiTi;

import leetcode.utils.ListNode;
import leetcode.utils.Utils;

/**
 * @author zhuliyang
 * @date 2020-04-03
 * @time 12:59
 **/
public class Test24 {
    public static void main(String[] args) {
        ListNode list = Utils.createList("[1,2,3,4,5]");
        reverseList(list);
        System.out.println(1);
    }
    public static ListNode reverseList(ListNode head) {
        ListNode root = new ListNode(-1);
        while (head!=null){
            ListNode temp = head.next;
            ListNode rootNext = root.next;
            root.next = head;
            head.next = rootNext;
            head = temp;
        }
        return root.next;
    }
}
