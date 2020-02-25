package leetcode.easy.test201To400;

/**
 * @author zhuliyang
 * @date 2020-02-09
 * @time 23:19
 **/
public class Test237 {
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
