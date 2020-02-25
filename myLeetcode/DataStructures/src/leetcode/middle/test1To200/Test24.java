package leetcode.middle.test1To200;

import leetcode.utils.ListNode;

/**
 * @author zhuliyang
 * @date 2020-02-19
 * @time 20:51
 **/
public class Test24 {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode root = new ListNode(0);
        ListNode pre = root;
        root.next = head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while(p1!=null&&p2!=null){
            ListNode temp = p2.next;
            pre.next = p2;
            p2.next = p1;
            p1.next = temp;
            pre = p1;//pre指针迭代
            p1=temp;//p1指针迭代
            if(p1==null)return root.next;
            p2=temp.next;//p2指针迭代
        }
        return root.next;
    }
}
