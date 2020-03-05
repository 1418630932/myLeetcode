package leetcode.middle.test1To200;

import leetcode.utils.ListNode;

import java.util.HashSet;

public class Test142 {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet();
        ListNode p = head;
        while(p!=null&&!set.contains(p)){
            set.add(p);
            p=p.next;
        }
        return p;
    }
}
