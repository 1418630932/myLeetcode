package leetcode.hard;

import leetcode.utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhuliyang
 * @date 2020-04-26
 * @time 0:14
 **/
public class Test23 {
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists==null ||lists.length==0)return null;
        ListNode root = new ListNode(-1);
        ListNode cur = root;
        while (true){
            int minIndex = -1;
            ListNode minNode =null;
            for (int i = 0; i <lists.length ; i++) {
                if (lists[i]!=null){
                    if (minNode==null){
                        minNode = lists[i];
                        minIndex = i;
                    }else {
                        if (minNode.val>lists[i].val){
                            minNode = lists[i];
                            minIndex =i;
                        }
                    }
                }
            }
            if (minIndex!=-1){
                cur.next = minNode;
                lists[minIndex] = minNode.next;
                minNode.next =null;
            }else break;
            cur = cur.next;
        }
        return root.next;
    }

    public int[] constructArr(int[] a) {
        int[] arr1 = new int[a.length];
        arr1[0] = a[0];
        int[] arr2 = new int[a.length];
        arr2[a.length-1] = a[a.length-1];
        for(int i=1;i<a.length;i++){
            arr1[i] = arr1[i=1]*a[i];
        }
        for(int i= arr2.length-2;i>=0;i--){
            arr2[i] = arr2[i+1]*a[i];
        }
        for(int i=0;i<a.length;i++){
            int  x = i-1<0?1:arr1[i-1];
            int  y = i+1==a.length?1:arr2[i+1];
            a[i] = x*y;
        }
        return a;
    }
}
