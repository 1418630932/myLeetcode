package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-01
 * @time 16:02
 **/
public class Test53 {
    public static void main(String[] args) {
        System.out.println(maxSubArray1(new int[]{-2,1,13,4,-1,-2,1,-5,4}));
    }
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int ans =nums[0];
        for (int num : nums) {
            if (sum<0){
                sum=num;
            }else {
                sum+=num;
            }
            ans=Math.max(sum,ans );//记录当前最大子序和
        }
        return ans;
    }


    public static int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length];
        int sum = nums[0];
        for (int i = 1; i <nums.length ; i++) {
            if (sum<0){
                sum=nums[i];
            }else {
                sum+=nums[i];
            }
            dp[i]=Math.max(sum,dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
