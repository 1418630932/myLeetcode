package leetcode.mianShiTi;

import leetcode.utils.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-04-01
 * @time 17:45
 **/
public class Test6 {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new LinkedList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        int[] arr = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            arr[list.size()-1-i]=list.get(i);
        }
        return arr;
    }
}
