package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-01-31
 * @time 17:40
 **/
public class Test21 {
    public static void main(String[] args) {

    }
     static  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode temp = root;
        while (l1!=null&&l2!=null){
            if (l1.val<l2.val){
                temp.next=l1;
                l1=l1.next;
            }else {
                temp.next=l2;

                l2=l2.next;
            }
            temp=temp.next;
        }
        temp.next=l1==null?l2:l1;//非空链表接上去
        return root.next;
    }
}


