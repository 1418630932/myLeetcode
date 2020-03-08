package leetcode.middle.test1To200;

import leetcode.utils.ListNode;
import leetcode.utils.Utils;

/**
 * @author zhuliyang
 * @date 2020-03-07
 * @time 18:14
 **/
public class Test147 {
    public static void main(String[] args) {
        ListNode node = insertionSortList(Utils.createList("[2,7,6,11,3,1]"));
        System.out.println(node);
    }
    public static ListNode insertionSortList(ListNode head) {
        if (head==null)return head;
        return sort(head);
    }
    public static ListNode sort(ListNode node){
        if (node.next==null)return node;
        ListNode sort = sort(node.next);
        ListNode dummy = new ListNode(-1);
        dummy.next = sort;
        ListNode pre = dummy;
        ListNode cur = sort;
        while (cur!=null){
            if (node.val<=cur.val){//找到位置
                node.next = cur;
                pre.next = node;
                break;
            }else {
                pre = cur;
                cur = cur.next;
            }
            if (cur==null){//插入末尾
                pre.next = node;
                node.next =null;
            }
        }
        return dummy.next;
    }
}
