package leetcode.easy.test1To200;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhuliyang
 * @date 2020-02-06
 * @time 14:34
 **/
public class Test141 {
    static  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while(cur!=null){
            if(set.contains(cur)){
                return false;
            }else{
                set.add(cur);
            }
            cur=cur.next;
        }
        return true;
    }
}
