package leetcode.easy.test201To400;

/**
 * @author zhuliyang
 * @date 2020-02-08
 * @time 20:05
 **/
public class Test206 {
    static  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        int[][] nums = {{1},{1,2},{1,2,3}};
    }
    public ListNode reverseList(ListNode head) {
        ListNode root = new ListNode(-1);
        ListNode cur = root;
        while(cur!=null){
            ListNode temp = new ListNode(cur.val);
            temp.next=root.next;
            root.next=temp;
            cur=cur.next;
        }
        return root.next;
    }
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            pre = cur;
            cur.next=pre;
            cur=next;
        }
        return pre;
    }
}
