package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-02
 * @time 17:57
 **/
public class Test83 {
    static  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur!=null){
            while (cur.next!=null&&cur.val==cur.next.val){
                cur.next=cur.next.next;
            }
            cur=cur.next;
        }
        return head;
    }
}

