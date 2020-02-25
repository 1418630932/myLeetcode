package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-08
 * @time 14:21
 **/
public class Test198 {
    public static void main(String[] args) {

    }
    public int rob(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        if (nums.length==1)return nums[0];
        int[] res = new int[nums.length];
        res[0]=nums[0];
        res[1]=Math.max(res[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            res[i]=Math.max(res[i-1],res[i-2]+nums[i]);
        }
        return res[nums.length-1];
    }
}
