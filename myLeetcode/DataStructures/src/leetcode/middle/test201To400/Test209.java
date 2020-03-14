package leetcode.middle.test201To400;

/**
 * @author zhuliyang
 * @date 2020-03-14
 * @time 14:16
 **/
public class Test209 {
    public static void main(String[] args) {
        int i = minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(i);
    }
    public static int minSubArrayLen1(int s, int[] nums) {
        int len = Integer.MAX_VALUE;
        for (int i = 0; i <nums.length ; i++) {
            int index = i;
            int sum =0;
            while (index>=0&&sum<s){
                sum+=nums[index--];
            }
            if (sum>=s){
                len = Math.min(len, i-index);
            }
        }
        return len==Integer.MAX_VALUE?0:len;
    }

    public static int minSubArrayLen(int s, int[] nums){
        int startIndex = 0;
        int len =Integer.MAX_VALUE;
        int sum =0;
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];
            while (sum>=s){
                len = Math.min(len,i-startIndex+1 );
                sum -=nums[startIndex++];
            }
        }
        return len==Integer.MAX_VALUE?0:len;
    }
}
