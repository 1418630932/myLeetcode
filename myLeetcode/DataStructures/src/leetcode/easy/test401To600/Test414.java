package leetcode.easy.test401To600;

import java.util.PriorityQueue;

/**
 * @author zhuliyang
 * @date 2020-02-13
 * @time 15:26
 **/
public class Test414 {
    public static void main(String[] args) {
        thirdMax(new int[]{5,2,4,1,3,6,0});
    }
    public static int thirdMax(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        PriorityQueue<Integer> priority = new PriorityQueue();
        int max =Integer.MIN_VALUE;
        for (int i : nums) {
            max = max>i?max:i;
            if (!priority.contains(i)){
                if (priority.size()<3){
                    priority.add(i);
                }else if (priority.size()==3&&priority.peek()<i){
                    priority.poll();
                    priority.add(i);
                }
            }
        }
        return priority.size()==3?priority.peek():max;
    }
}
