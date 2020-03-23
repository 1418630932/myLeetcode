package leetcode.easy.test801To1000;

import leetcode.utils.ListNode;

/**
 * @author zhuliyang
 * @date 2020-03-23
 * @time 13:17
 **/
public class Test876 {
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2!=null&&p2.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
}
