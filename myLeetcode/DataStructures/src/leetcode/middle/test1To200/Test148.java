package leetcode.middle.test1To200;

import leetcode.utils.ListNode;
import leetcode.utils.Utils;

/**
 * @author zhuliyang
 * @date 2020-03-07
 * @time 21:57
 **/
public class Test148 {
    public static void main(String[] args) {
        ListNode node = sortList(Utils.createList("[2,7,6,11,3,1]"));
        System.out.println(node);
    }
    public static ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    private static ListNode mergeSort(ListNode head) {
        if (head==null||head.next==null)return head;
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode slowNext = slow.next;
        slow.next =null;
        ListNode first  = mergeSort(head);//前半段
        ListNode half = mergeSort(slowNext);//后半段
        return mergeList(first,half);
    }

    private static ListNode mergeList(ListNode first, ListNode half) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (first!=null&&half!=null){
            if (first.val<=half.val){
                pre.next = first;
                pre = first;
                first = first.next;
            }else {
                pre.next = half;
                pre = half;
                half = half.next;
            }
            if (first==null){
                pre.next = half;
            }
            if (half==null){
                pre.next = first;
            }
        }
        return dummy.next;
    }
}
