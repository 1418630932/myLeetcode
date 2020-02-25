package leetcode.easy.test201To400;

/**
 * @author zhuliyang
 * @date 2020-02-08
 * @time 15:10
 **/
public class Test203 {
    static  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode root = new ListNode(-1);
        root.next=head;
        ListNode pre = root;
        ListNode temp = head;
        while(temp!=null){
            if(temp.val==val){
                pre.next=temp.next;
                temp=pre.next;
            }else{
                pre = temp;
                temp=temp.next;
            }
        }
        return root.next;
    }
}
