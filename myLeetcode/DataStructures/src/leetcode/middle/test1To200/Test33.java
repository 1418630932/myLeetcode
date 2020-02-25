package leetcode.middle.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-20
 * @time 15:30
 **/
public class Test33 {
    public int search(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target)return i;
        }
        return -1;
    }
}
