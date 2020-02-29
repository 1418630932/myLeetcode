package leetcode.middle.test1To200;

import leetcode.easy.test1To200.Test1;
import leetcode.utils.ListNode;
import leetcode.utils.TreeNode;
import leetcode.utils.Utils;

import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-02-29
 * @time 15:40
 **/
public class Test109 {
    public static void main(String[] args) {
        TreeNode treeNode = sortedListToBST(Utils.createList("[1,2,3,4,5]"));
        System.out.println(treeNode);
    }
    public static TreeNode sortedListToBST(ListNode head) {
        if (head==null)return null;
        if (head.next==null)return new TreeNode(head.val);
        ListNode pre =head;
        ListNode p = head.next;
        ListNode q = head.next.next;
        //找到链表的中点p 双指针法
        while (q!=null&&q.next!=null){
            pre = pre.next;//一步指针
            p = p.next;
            q = q.next.next;//两步指针
        }
        pre.next = null;//把链表分成两段  前半段 ，后半段
        TreeNode root = new TreeNode(p.val);
        root.left = sortedListToBST(head);//左子树
        root.right = sortedListToBST(p.next);//右子树
        return root;
    }
}
