package leetcode.middle.test1To200;

import leetcode.utils.ListNode;

/**
 * @author zhuliyang
 * @date 2020-02-26
 * @time 14:52
 **/
public class Test82 {
    public static void main(String[] args) {

    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur!=null){
            if (pre.val == cur.val){
                pre.next = cur.next;

            }else {
                pre =cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
