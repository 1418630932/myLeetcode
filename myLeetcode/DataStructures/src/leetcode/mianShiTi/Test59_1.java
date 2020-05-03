package leetcode.mianShiTi;

import java.util.*;

/**
 * @author zhuliyang
 * @date 2020-04-25
 * @time 13:32
 **/
public class Test59_1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3 )));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        Deque<Integer> queue = new LinkedList<>();
        int j=0;
        for (int i = 0; i <nums.length ; i++) {
            if (queue.size()>=k)queue.poll();
            //保证队列的单调递减性
            while (!queue.isEmpty()&&nums[i]>nums[queue.getLast()]){
                queue.removeLast();
            }
            queue.add(i);
            if (i>=k-1)res[j++]=nums[queue.peek()];
        }
        return res;
    }
}
