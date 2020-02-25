package leetcode.easy.test201To400;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhuliyang
 * @date 2020-02-09
 * @time 19:06
 **/
public class Test234 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        a.next=b;
        isPalindrome(a);
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();
        ListNode cur = head;
        while (cur!=null){
            deque.addLast(cur);
            cur = cur.next;
        }
        while (deque.size()>1){
            if(deque.removeFirst().val!=deque.removeLast().val){
                return false;
            }
        }
        return true;
    }
}
