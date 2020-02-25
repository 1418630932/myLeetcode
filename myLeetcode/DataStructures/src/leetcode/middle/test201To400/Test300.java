package leetcode.middle.test201To400;

/**
 * @author zhuliyang
 * @date 2020-02-11
 * @time 23:47
 **/
public class Test300 {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int minIndex =0;
        dp[0]=1;
        for (int i = 1; i <nums.length ; i++) {
            if (nums[minIndex]>nums[i]){
                minIndex=i;
                dp[i]=1;
            }else {
                for (int j = 0; j <=i ; j++) {
                    if (nums[j]<nums[i]){
                        dp[i]=Math.max(dp[i],dp[j]+1);
                    }
                }
            }
        }
        int max = 0;
        for (int i : dp) {
            max= max>i?max:i;
        }
        return max;
    }
}
