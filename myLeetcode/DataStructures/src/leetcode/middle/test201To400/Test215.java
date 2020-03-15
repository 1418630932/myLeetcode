package leetcode.middle.test201To400;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author zhuliyang
 * @date 2020-03-15
 * @time 16:29
 **/
public class Test215 {
    public static void main(String[] args) {
        int kthLargest = findKthLargest(new int[]{1, 2, 9, 3, 4, 1, 6, 4, 5, 2}, 2);
        System.out.println(kthLargest);
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i <nums.length ; i++) {
            if (queue.size()<k){
                queue.add(nums[i]);
            }else {
                if (nums[i]>queue.peek()){
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }
        return queue.peek();
    }
}
