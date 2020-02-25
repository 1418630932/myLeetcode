package leetcode.middle.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-22
 * @time 21:04
 **/
public class Test55 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{1,0,3}));
    }
    //贪心
    public static boolean canJump(int[] nums) {
        if(nums==null)return false;
        int k=0;//当前能跳到的最大索引位置
        for (int i = 0; i <nums.length; i++) {
            if (i>k)return false;//当前位置>最大位置 表示永远都跳不到
            k=Math.max(k,nums[i]+i);//不断更新k
        }
        return true;//循环结束 表示到达终点
    }
    //暴力+剪枝
    public  boolean canJump1(int[] nums) {
        if(nums==null||nums.length==0)return false;
        return helper(nums,0,0);
    }
    public  boolean helper(int[] nums ,int start,int step){
        if (start+step==nums.length-1)return true;//到达终点
        if(nums[start+step]==0)return false;//无法跳跃
        boolean res = false;
        for(int i=1;i<=nums[start+step]&&start+step<nums.length;i++){
            boolean canJump =  helper(nums,start+step,i);
            if (canJump){
                return true;
            }else {
                res = canJump;
            }
        }
        return res;
    }

}
