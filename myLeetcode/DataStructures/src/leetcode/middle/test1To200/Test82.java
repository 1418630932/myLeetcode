package leetcode.middle.test1To200;

import leetcode.utils.ListNode;
import leetcode.utils.Utils;

import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-02-26
 * @time 14:52
 **/
public class Test82 {
    public static void main(String[] args) {
        ListNode list = Utils.createList("[1,1,2,3,3,4,5,6]");
        ListNode listNode = deleteDuplicates2(list);
        System.out.println(listNode);
    }
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return null;
        ListNode root = new ListNode(-1);
        ListNode temp = root;
        ListNode pre = head;
        ListNode cur = head.next;
        if (cur==null)return head;
        while (cur != null) {
            if (pre.val==cur.val){//如果出现值相同 就循环查找到不相同的节点为止
                while (cur!=null&&cur.val==pre.val){
                    cur = cur.next;
                }
                pre = cur;
                if (cur==null){
                    temp.next=null;
                    break;//如果到了最后 就跳出循环
                }
            }else {
                temp.next = pre;
                temp = pre;
                pre = cur;
            }
            cur = cur.next;
            if (cur==null){
                temp.next=pre;
                pre.next = cur;
            }
        }
        return root.next;
    }
}
