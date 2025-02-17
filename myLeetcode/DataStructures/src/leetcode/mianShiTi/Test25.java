package leetcode.mianShiTi;

import leetcode.utils.ListNode;

/**
 * @author zhuliyang
 * @date 2020-04-03
 * @time 13:11
 **/
public class Test25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
        ListNode cur = root;
        while (l1!=null&&l2!=null){
            if (l1.val<l2.val){
                cur.next = l1;
                l1=l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
            if (l1==null){
                cur.next = l2;
            }
            if (l2==null){
                cur.next=l1;
            }
        }
        return root.next;
    }
}
