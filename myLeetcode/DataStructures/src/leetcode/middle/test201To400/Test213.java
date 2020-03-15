package leetcode.middle.test201To400;

/**
 * @author zhuliyang
 * @date 2020-03-15
 * @time 15:39
 **/
public class Test213 {
    public static void main(String[] args) {
        int rob = rob(new int[]{2, 3, 2});
        System.out.println(rob);
    }
    public static int rob(int[] nums) {
        if (nums.length==1)return nums[0];
        int[] dpWithOne = new int[nums.length];
        int[] dpWithoutOne = new int[nums.length];
        dpWithOne[0] = nums[0];
        dpWithOne[1] = Math.max(nums[1],nums[0] );
        dpWithoutOne[0] = 0;
        dpWithoutOne[1] = nums[1];
        for (int i = 2; i <nums.length ; i++) {
            dpWithOne[i] =Math.max(dpWithOne[i-1],dpWithOne[i-2]+nums[i]);
            dpWithoutOne[i] = Math.max(dpWithoutOne[i-1],dpWithoutOne[i-2]+nums[i]);
        }
        return Math.max(dpWithOne[nums.length-2],dpWithoutOne[nums.length-1] );
    }
}
