package leetcode.easy.test401To600;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-02-15
 * @time 16:55
 **/
public class Test453 {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int count =0;
        for (int i = nums.length - 1; i >= 0; i--) {
            count+=nums[i]-nums[0];
        }
        return count;
    }
}
