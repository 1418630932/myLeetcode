package leetcode.middle.test1To200;

/**
 * @author zhuliyang
 * @date 2020-03-08
 * @time 16:16
 **/
public class Test152 {
    public static void main(String[] args) {
        int i = maxProduct(new int[]{2, 3, -2,4});
        System.out.println(i);
    }
    public static int maxProduct(int[] nums) {
        if (nums.length==1)return nums[0];
        int[] dp1 = new int[nums.length];  //包含第i个数的时候的最大正数值
        int[] dp2 = new int[nums.length];  //包含第i个数的时候的最小负数值
        if (nums[0]>=0){
            dp1[0]=nums[0];
            dp2[0]=0;
        }else {
            dp1[0]=0;
            dp2[0]=nums[0];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <nums.length ; i++) {
            if (nums[i]>=0){
                dp1[i] = Math.max(nums[i],dp1[i-1]*nums[i]);
                dp2[i] = Math.min(0,dp2[i-1]*nums[i] );
            }else {
                dp1[i] = Math.max(0,dp2[i-1]*nums[i]);//负负得正
                dp2[i] = Math.min(nums[i],dp1[i-1]*nums[i] );//正负得负
            }
        }

        for (int i : dp1) {
            max = Math.max(i,max );
        }
        return max;
    }
}
