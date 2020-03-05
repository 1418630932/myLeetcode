package leetcode.middle.test1To200;

import leetcode.utils.ListNode;
import leetcode.utils.Utils;

/**
 * @author zhuliyang
 * @date 2020-03-05
 * @time 19:05
 **/
public class Test143 {
    public static void main(String[] args) {
        ListNode list = Utils.createList("[1,2,3,4,5,6,7]");
        reorderList(list);
        System.out.println(list);
    }

    public static void reorderList(ListNode head) {
        //切割链表
        ListNode root = cutNode(head);
        //翻转另外一条链表
        ListNode reverse =reverseNode(root);
        //组装两条链表
        merge(head,reverse);
    }

    private static void merge(ListNode head, ListNode root) {
        ListNode p = root;
        ListNode q = head;
        while (p!=null){
            ListNode tail = q.next;
            ListNode pre = p.next;
            q.next = p;
            p.next=tail;
            p = pre;
            q = tail;
        }
    }

    private static ListNode cutNode(ListNode head) {
        int count =0;
        ListNode cur = head;
        while (cur!=null){
            cur = cur.next;
            count++;
        }
        int mid = (count&1)==1?count/2+1:count/2;
        count=1; cur = head;
        while (count++<mid){
            cur = cur.next;
        }
        //断开链表成两条
        ListNode root = cur.next; //第二张链表
        cur.next = null;
        return root;
    }

    private static ListNode reverseNode(ListNode root) {
        if (root==null||root.next==null) return root;
        ListNode dummy = new ListNode(-1);
        ListNode cur = root;
        while (cur!=null){
            ListNode tail = cur.next;
            ListNode next = dummy.next;
            dummy.next = cur;
            cur.next = next ;
            cur = tail;
        }
        return dummy.next;
    }
}
