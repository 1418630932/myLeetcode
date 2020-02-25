package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-06
 * @time 15:24
 **/
public class Test160 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //headA [1-2-3-4-5-NULL]
    //headB [6-7-8-9-NULL]
    //headA-headB [1-2-3-4-5-NULL-6-7-8-9-NULL]
    //headB-headA [6-7-8-9-NULL-1-2-3-4-5-NULL]
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null||headB==null)return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a!=b){
            a=(a==null?headB:a.next);
            b=(b==null?headA:b.next);
        }
        return a;
    }
}
