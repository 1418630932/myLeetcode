package leetcode.middle.test1To200;

import leetcode.utils.ListNode;
import leetcode.utils.Utils;

import java.util.HashMap;

/**
 * @author zhuliyang
 * @date 2020-02-27
 * @time 0:57
 **/
public class Test92 {
    public static void main(String[] args) {
        ListNode list = Utils.createList("[1,2,3,4,5]");
        ListNode listNode = reverseBetween1(list, 3, 4);
        System.out.println(listNode);
    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m==n)return head;
        ListNode root = new ListNode(-1);
        root.next= head;
        int count = 1 ;
        ListNode tail = m==1?head:null;
        ListNode cur  = head.next;
        ListNode preFirst = m==1?root:m==2?head:null;
        while (cur!=null){
            count++;
            if (count==m-1){
                preFirst = cur;
            }
            if (count==m){
                tail = cur;
            }
            ListNode temp = cur.next;
            if (count>m&&count<=n){
                ListNode next = preFirst.next;
                preFirst.next = cur;
                cur.next = next;
                tail.next = temp;
            }
            if (count==n+1){
                break;
            }
            cur = temp;
        }
        return root.next;
    }


    public static ListNode reverseBetween1(ListNode head, int m, int n){
        ListNode root = new ListNode(-1);
        root.next= head;
        ListNode pre = root;
        for (int i = 1; i <m ; i++) {//找到翻转链的前继节点
            pre = pre.next;
        }
        head = pre.next;
        for(int i = m; i < n; i++){
            ListNode nex = head.next;
            head.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return root.next;
    }
}
